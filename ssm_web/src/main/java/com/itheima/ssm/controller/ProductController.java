package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        System.out.println("sss");
        List<Product> productList = productService.findAll();
        mv.addObject("productList",productList);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/saveProductReturnId")
    public ModelAndView saveProductReturnId(Product product) {
        String id = productService.saveProductReturnId(product);
        ModelAndView mv = new ModelAndView();
        mv.addObject("id", id);
        mv.setViewName("redirect:/product/findById");
        return mv;
    }

    @RequestMapping("/saveProduct")
    public ModelAndView saveProduct(Product product) {
        System.out.println("====controller===");
        System.out.println(product);
        productService.saveProduct(product);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/product/findAll");
        return mv;
    }

    @RequestMapping("/findById")
    public void findById(String id) {
        Product product = productService.findById(id);
        System.out.println(product);
    }
}
