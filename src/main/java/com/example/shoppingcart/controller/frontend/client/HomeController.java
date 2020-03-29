package com.example.shoppingcart.controller.frontend.client;


import com.example.shoppingcart.model.request.view_model.HomeViewModel;
import com.example.shoppingcart.model.request.view_model.ProductViewModel;
import com.example.shoppingcart.service.CategoryService;
import com.example.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
@RequestMapping("/frontend/client")

public class HomeController extends BaseController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String home(Model model,
                       @ModelAttribute("productname") ProductViewModel productName,
                       HttpServletRequest request,
                       HttpServletResponse response,
                       final Principal principal) {

        this.checkCookie(response, request, principal);

        HomeViewModel homeViewModel = new HomeViewModel();

        homeViewModel.setCategoryViewModels(categoryService.getListCategoryViewModel());

        homeViewModel.setProductViewModels(productService.getListProductViewModel());

        model.addAttribute("homeViewModel", homeViewModel);

        return "index";
    }

}
