package com.ksit.tms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ksit.tms.entity.Account;
import com.ksit.tms.entity.Ticket;
import com.ksit.tms.entity.TicketInRecord;
import com.ksit.tms.entity.TicketInRecordExample;
import com.ksit.tms.exception.ServiceException;
import com.ksit.tms.mapper.TicketInRecordMapper;
import com.ksit.tms.mapper.TicketMapper;
import com.ksit.tms.service.TicketService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class TicketServicveImpl implements TicketService {

    //记录日志
    private Logger logger = LoggerFactory.getLogger(TicketServicveImpl.class);

    @Autowired
    private TicketInRecordMapper ticketInRecordMapper;
    @Autowired
    private TicketMapper ticketMapper;

    /**
     * 新增年票记录
     *
     * @param ticketInRecord
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void insertTicketInRecord(TicketInRecord ticketInRecord) {
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();
        //region 新增年票记录
        //1.检查票号是否合法
        //2.判断当前票号和已存在的票号是否重复,如果重复打回
        //3.设置新增时间
        //4.每次插入都要设置更新数量
        //5.将每次入库的备注设置为票号区间
        //6.保存日志
        //7.将年票保存到年票表中,每一张年票都要保存一条
        //8.事务回滚
        //endregion

        //检查票号是否合法,就是截至票号不能大于开始票号
        BigInteger begin = new BigInteger(ticketInRecord.getBeginTicketNum());
        BigInteger end = new BigInteger(ticketInRecord.getEndTicketNum());
        //检查
        if (begin.compareTo(end)>=0){
            throw new ServiceException("结束票号不能小于起始票号");
        }

        //判断当前票号和已经存在的票号是否重复,去将所有的记录都查出来,比对开始和结束票号
        for (TicketInRecord inRecord : ticketInRecordMapper.selectByExample(new TicketInRecordExample())) {
            if (inRecord!=null){
                BigInteger recordEnd = new BigInteger(inRecord.getEndTicketNum());
                BigInteger recordStart = new BigInteger(inRecord.getBeginTicketNum());
                //如果新插入的记录的开始票号比任何一个记录的结束票号小,打回
                if (begin.compareTo(recordEnd)<=0){
                    throw new ServiceException("票号区间重复");
                }
            }
        }

        //设置入库时间
        ticketInRecord.setCreateTime(new Date());

        //总数量 = (结束数量-开始数量) + 1 ,总数量还有用,不要使用匿名对象
        int total = end.subtract(begin).add(new BigInteger("1")).intValue();
        ticketInRecord.setTotalNum(total);

        //设置备注
        ticketInRecord.setContent(begin + "-" + end);

        //为TicketInRecord 设置accountId 和account name
        ticketInRecord.setAccountId(account.getId());
        ticketInRecord.setAccountName(account.getAccountName());

        //exec
        ticketInRecordMapper.insertSelective(ticketInRecord);
        //记录日志,同时记录操作账户
        logger.info("插入年票记录{},操作账户:{}",ticketInRecord,account);

        //处理关联关系,保存每一张年票到年票表中去
        List<Ticket> ticketList = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            //每有一条记录,创建一个Ticket 对象
            Ticket ticket = new Ticket();
            ticket.setCreateTime(new Date());
            ticket.setTicketInTime(new Date());
            //设置票号,作为ticket 的id 使用
            ticket.setTicketNum(String.valueOf(begin.add(BigInteger.valueOf(i))));
            ticket.setTicketState(Ticket.TICKET_STATE_IN_STORE);
            ticketList.add(ticket);
        }

        //使用批量保存TicketList,而不是一张一张来,太慢
        batchInsertTicket(ticketList);
    }

    /**
     * 查询分页数据
     *
     * @param pageNo
     * @return
     */
    @Override
    public PageInfo<TicketInRecord> selectTicketRecordByPageNo(Integer pageNo) {
        //对数据分页需要一个PageHelper 对象,使用这个对象来设置相关参数,每页显示五条数据
        PageHelper.startPage(pageNo,5);

        TicketInRecordExample ticketInRecordExample = new TicketInRecordExample();

        //使用id 排序,倒排
        ticketInRecordExample.setOrderByClause("id desc");

        List<TicketInRecord> ticketInRecords = ticketInRecordMapper.selectByExample(ticketInRecordExample);
        return new PageInfo<>(ticketInRecords);
    }


    /**
     * 批量插入,解决mybaits 参数找不到的问题
     * @param ticketList
     */
    public void batchInsertTicket(@Param("ticketList") List<Ticket> ticketList){
        ticketMapper.batchInsertTicket(ticketList);
    }
}
