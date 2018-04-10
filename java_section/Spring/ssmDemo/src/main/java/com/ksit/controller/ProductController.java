package com.ksit.controller;

import com.ksit.entity.Product;
import com.ksit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    /**
     * 会自动注入 productService 的实现类
     */
    @Autowired
    private ProductService productService;

    @GetMapping("/{id:\\d+}")
    public String selectById(@PathVariable Integer id, Model model){

        Product product = productService.selectById(id);
        System.out.println(product);

        if (product!=null){
            model.addAttribute("product",product);

            return "product/selectById";
        }else {
            throw new com.ksit.exception.NotFoundException();
        }
    }
}
