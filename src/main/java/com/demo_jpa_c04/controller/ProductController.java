package com.demo_jpa_c04.controller;

import com.demo_jpa_c04.model.Category;
import com.demo_jpa_c04.model.Product;
import com.demo_jpa_c04.repository.ProductRepo;
import com.demo_jpa_c04.service.ICategoryService;
import com.demo_jpa_c04.service.IProductService;
import com.demo_jpa_c04.validation.ValidName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    ValidName validName;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.getAll();
    }

    @GetMapping
    public ModelAndView home1(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String nameSearch) {
        ModelAndView modelAndView = new ModelAndView("home");
        Page<Product> products = productService.getAll(PageRequest.of(page, 3, Sort.by("price")), nameSearch);
        modelAndView.addObject("products", products);
        modelAndView.addObject("nameSearch", nameSearch);
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home2(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String nameSearch) {
        ModelAndView modelAndView = new ModelAndView("index");
        Page<Product> products = productService.getAll(PageRequest.of(page, 3, Sort.by("price")), nameSearch);
        modelAndView.addObject("products", products);
        modelAndView.addObject("nameSearch", nameSearch);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, int idCategory) {
        validName.validate(product, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        productService.save(product, idCategory);
        return "redirect:/products";
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/products";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products";
    }
}
