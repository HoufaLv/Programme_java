package com.ksit.tms.service;

import com.github.pagehelper.PageInfo;
import com.ksit.tms.entity.TicketInRecord;

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
}
