package com.embatask.productmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class AccessDeniedController {

    @GetMapping("/accessdenied")
    public ModelAndView accessdenied() {
        return new ModelAndView("web/accessdenied");
    }
}
