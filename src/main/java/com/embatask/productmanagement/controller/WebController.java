package com.embatask.productmanagement.controller;

import com.embatask.productmanagement.domain.Product;
import com.embatask.productmanagement.domain.Role;
import com.embatask.productmanagement.domain.User;
import com.embatask.productmanagement.service.UserService;
import com.embatask.productmanagement.validator.ProductValidator;
import com.embatask.productmanagement.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class WebController {
    @Autowired
    private UserValidator userValidator;

    @InitBinder
    public void initProductBinder(WebDataBinder dataBinder) {
        if (dataBinder.getTarget() != null && (dataBinder.getTarget()).getClass() == User.class) {
            dataBinder.setValidator(userValidator);
        }
    }

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showIndex() {
        return "web/login";
    }


    @GetMapping("/login")
    public String showLogin() {
        return "web/login";
    }

    @GetMapping("/logout")
    private String logout() {
        return "redirect:/login";
    }

    @GetMapping("/register")
    public ModelAndView showRegistration() {
        ModelAndView mav = new ModelAndView("web/register");
        mav.addObject("user", new User());
        return mav;
    }


    @PostMapping("/register-submit")
    public ModelAndView registerSubmit(@ModelAttribute @Validated User user, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        if (result.hasErrors()) {
            result.getAllErrors();
            mav.setViewName("user/index");
        } else {
            userService.addUser(user);
            System.out.println("Ugurla qeydiyyatdan kecdiniz");
            mav.setViewName("redirect:/");
        }
        return mav;
    }


}


