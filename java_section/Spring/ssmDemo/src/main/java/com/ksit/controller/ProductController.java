package com.ksit.controller;

import com.github.pagehelper.PageInfo;
import com.ksit.entity.Product;
import com.ksit.entity.ProductType;
import com.ksit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lvhoufa
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    /**
     * 会自动注入 productService 的实现类
     */
    @Autowired
    private ProductService productService;

    /**
     * 根据 id 来查询对应的商品信息
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id:\\d+}")
    public String selectById(@PathVariable Integer id, Model model) {

        Product product = productService.selectById(id);

        System.out.println(product);

        if (product != null) {
            model.addAttribute("product", product);

            return "product/selectById";
        } else {
            throw new com.ksit.exception.NotFoundException();
        }
    }

    /**
     * 查出所有商品信息 传给前端
     * 还要根据type id 查询出对应的typeName
     *
     * @param model
     * @return
     */
    @GetMapping
    public String listAll(@RequestParam(defaultValue = "1", name = "p", required = false) Integer pageNo,
                          @RequestParam(required = false) String productName,
                          @RequestParam(required = false) String place,
                          @RequestParam(required = false) String minPrice,
                          @RequestParam(required = false) String maxPrice,
                          Model model) throws UnsupportedEncodingException {

        //完成动态搜索的功能
        //从前端传过来的如果是中文,有可能会乱码
        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("productName", productName);
        paramsMap.put("place", place);
        paramsMap.put("minPrice", minPrice);
        paramsMap.put("maxPrice", maxPrice);

        PageInfo<Product> productPageInfo = productService.selectProductByPageNoWithParamMap(pageNo, paramsMap);

        //从前端获取页号,根据页号去查询对应的数据,返回给前端
        /*PageInfo<Product> productPageInfo = productService.selectProductByPageNo(pageNo);
        System.out.println("total page number is :" + productPageInfo.getPages());*/

        model.addAttribute("pageInfo", productPageInfo);
        model.addAttribute("typeList", productService.selectAllType());
        return "product/list";
    }

    /**
     * 查询出所有的分类名称,然后将所有的分类信息传给前端
     *
     * @param model
     * @return
     */
    @GetMapping("/new")
    public String insertProduct(Model model) {
        List<ProductType> productTypeList = productService.selectAllType();
        model.addAttribute("productTypeList", productTypeList);
        return "product/insertProduct";
    }

    /**
     * 新增商品
     *
     * @param product 商品
     * @return
     */
    @PostMapping("/new")
    public String insertProduct(Product product, RedirectAttributes redirectAttributes) {

        //接收到前端传过来的数据,保存到数据库中去
        productService.insertProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/{id:\\d+}/del")
    public String deleteProduct(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        //做删除
        productService.deleteProduct(id);
        return "redirect:/product";
    }

    @GetMapping("/{id:\\d+}/edit")
    public String editProduct(@PathVariable Integer id, Model model) {
        //做编辑,前端点击编辑按钮,可以获得id传过来,跳转到编辑页面,然后提交表单
        List<ProductType> productTypeList = productService.selectAllType();
        model.addAttribute("productTypeList", productTypeList);
        Product product = productService.selectById(id);
        model.addAttribute("product", product);
        return "product/edit";
    }


    @PostMapping("/{id:\\d+}/edit")
    public String editProduct(Product product, RedirectAttributes redirectAttributes) {
        productService.updateProduct(product);
        redirectAttributes.addFlashAttribute("message", "update product success!");
        return "redirect:/product";
    }

}
