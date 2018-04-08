package com.ksit.controller;

import com.ksit.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

/**
 * @author Lvhoufa
 */
@Controller
@RequestMapping( value = "/customer")
public class CustomerController {

    @GetMapping("/add")
    public String customerAdd(){
        return "customer/add";
    }

    /**
     * 编写业务控制器,请求路径为:/customer/id=1001 其中限制id 为纯数字,通过正则表达式来进行限制
     * 这个GetMapping 注解中的id 必须和 下面的方法中的参数的名字保持一致,要在方法的参数前面加上@PathVriable 注解
     * 方法的返回值为 ModelAndView 表示通过 ModelAndView 对象来确定返回值和视图名称
     * @param id
     * @return
     */
    @GetMapping(value = "/{id:\\d+}")
    public ModelAndView viewCustomer(@PathVariable Integer id){
        System.out.println("id = " + id);

        //通过ModelAndView 对象来传值和跳转页面
        ModelAndView modelAndView = new ModelAndView("customer/view");

        //通过这个方法来像页面中传递数据
        modelAndView.addObject("id",id);

        //跳转到customer/view 这个路径下的页面
        return modelAndView;
    }

    /**
     * url 中有多个参数,根据性别和id 来查看customer
     * 在 GetMapping 后面的value 中可以跟多个参数 通过 / 符号来分割
     * @param gender
     * @param id
     * @return
     */
    @GetMapping(value = "/{gender:\\d{1}}/{id:\\d+}")
    public ModelAndView viewCustomerByNameGender(@PathVariable Integer gender,@PathVariable Integer id){
        System.out.println("gender = " + gender);
        System.out.println("id = " + id);

        //创建ModelAndView 对象
        ModelAndView modelAndView = new ModelAndView("customer/view");

        //通过ModelAndView 对象来跳转视图和 传递变量
        modelAndView.addObject("gender",gender);

        return modelAndView;
    }

    /**
     * 直接跳转到new.jsp 也页面去 准备进行添加操作
     * @return
     */
    @GetMapping(value = "/new")
    public String newCustomer(){
        return "customer/new";
    }

    /**
     * 默认 dopost 提交行为
     * @param name
     * @param gender
     * @return
     */
    /*@PostMapping(value = "/new")
    public String newCustomer(String name,Integer gender){
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        return "redirect:/customer/new";
    }*/

    /**
     * spring mvc 会尽量去封装实体对象,将能对应的上的字段全部都对应上
     * @param customer
     * @return
     */
    @PostMapping(value = "/new")
    public String newCustomer(Customer customer) throws UnsupportedEncodingException {

        System.out.println("customer.name = " + new String(customer.getName().getBytes(),"UTF-8"));
        System.out.println("customer.gender = " + customer.getGender());
        return "redirect:/customer/new";
    }

    /**
     * 使用ResponseBody 注解标记相应体,这样将不做视图间的跳转,而是输出为字符串,但是默认为IOS8859-1
     * 可以使用produces 属性来限制返回类型为什么,比如 produces = "text/html;charset=UTF-8"
     * @return
     */
    @GetMapping(value = "/showC",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String showCustomerInConsole(){
        return "显示为string 不做视图间的跳转";
    }
}
