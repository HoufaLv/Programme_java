package com.ksit.tms.service.impl;

import com.ksit.tms.entity.StoreAccount;
import com.ksit.tms.entity.TicketStore;
import com.ksit.tms.entity.TicketStoreExample;
import com.ksit.tms.mapper.StoreAccountMapper;
import com.ksit.tms.mapper.TicketStoreMapper;
import com.ksit.tms.service.TicketStoreService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Lvhoufa
 */
@Service
public class TicketStoreServiceImpl implements TicketStoreService {

    @Autowired
    private TicketStoreMapper ticketStoreMapper;

    @Autowired
    private StoreAccountMapper storeAccountMapper;

    /**
     * 新增销售点信息
     * 对多张表的操作要使用事务
     *
     * @param ticketStore
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void insertTicketStore(TicketStore ticketStore) {

        //1.设置新增时间
        ticketStore.setStoreRegisterTime(new Date());

        //2.插入数据
        ticketStoreMapper.insert(ticketStore);

        //3.创建对应账户
        StoreAccount storeAccount = new StoreAccount();
        //销售账号为手机号
        storeAccount.setStoreAccount(ticketStore.getStoreTel());
        //密码为手机号后六位,MD5加密
        storeAccount.setStorePassword(DigestUtils.md5Hex(ticketStore.getStoreTel().substring(5)));
        storeAccount.setCreateTime(new Date());
        storeAccount.setUpdateTime(new Date().toString());
        storeAccount.setStoreState(StoreAccount.ACCOUNT_STATE_NORMAL);
        //4.添加对应关系,需要在mapper 中获取自动增长的主键
        storeAccount.setTicketStoreId(ticketStore.getId());

        storeAccountMapper.insertSelective(storeAccount);

        //5.然后再去更新tickStore 中的 ticked account id
        ticketStore.setStoreAccountId(storeAccount.getId());
        ticketStoreMapper.updateByPrimaryKeySelective(ticketStore);


    }

    /**
     * 查询所有售票点信息
     *
     * @return
     */
    @Override
    public List<TicketStore> selectAllTicketStore() {
        return ticketStoreMapper.selectByExample(new TicketStoreExample());
    }

    /**
     * 根据id 查询售票点信息
     *
     * @param id
     * @return
     */
    @Override
    public TicketStore selectTIcketStoreById(Integer id) {
        return ticketStoreMapper.selectByPrimaryKey(id);
    }
}
