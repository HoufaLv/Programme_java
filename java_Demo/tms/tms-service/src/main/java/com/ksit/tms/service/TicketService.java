package com.ksit.tms.service;

import com.github.pagehelper.PageInfo;
import com.ksit.tms.entity.TicketInRecord;
import com.ksit.tms.entity.TicketOutRecord;

public interface TicketService {
    /**
     * 新增年票记录
     * @param ticketInRecord
     */
    void insertTicketInRecord(TicketInRecord ticketInRecord);

    /**
     * 查询分页数据
     * @param pageNo
     * @return
     */
    PageInfo<TicketInRecord> selectTicketRecordByPageNo(Integer pageNo);

    /**
     * 删除年票入库记录
     * @param id
     */
    void deleteTicketInRecord(Integer id);

    /**
     * 年票下发记录分页处理
     * @param pageNo
     * @return
     */
    PageInfo<TicketOutRecord> selectTicketOutRecordByPageNo(Integer pageNo);

    /**
     * 年票下发记录
     * @param ticketOutRecord
     */
    void saveTicketOutRecord(TicketOutRecord ticketOutRecord);
}
