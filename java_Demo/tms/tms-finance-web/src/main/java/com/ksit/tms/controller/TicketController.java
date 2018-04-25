package com.ksit.tms.controller;

import com.github.pagehelper.PageInfo;
import com.ksit.tms.entity.TicketInRecord;
import com.ksit.tms.service.TicketService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 票务相关业务控制器
 * 公共前缀为 /ticket
 *
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    /**
     * 跳转到票务管理首页
     * @return
     */
    @GetMapping("/storage")
    public String ticketHome(Model model, @RequestParam(required = false,defaultValue = "1",name = "p")Integer pageNo){
        PageInfo<TicketInRecord> pageInfo = ticketService.selectTicketRecordByPageNo(pageNo);

        //将分页数据传到前端
        model.addAttribute("pageInfo",pageInfo);
        return "ticket/storage/home";
    }

    /**
     * 跳转到年票入库页面,将时间固定,传到前端去
     * @return
     */
    @GetMapping("/storage/new")
    public String insertTicket(Model model){
        //使用服务器时间做标准,传给前端,在页面上做固定展示
        String time =DateTime.now().toString("YYYY-MM-dd");
        model.addAttribute("time",time);

        return "/ticket/storage/insertTicket";
    }
    @PostMapping("/storage/new")
    public String insertTicket(TicketInRecord ticketInRecord, RedirectAttributes redirectAttributes){
        //去业务层去处理业务,将数据进行保存
        ticketService.insertTicketInRecord(ticketInRecord);
        redirectAttributes.addFlashAttribute("message","年票入库成功");

        //跳转到展示页面去
        return "/ticket/storage/home";
    }
}