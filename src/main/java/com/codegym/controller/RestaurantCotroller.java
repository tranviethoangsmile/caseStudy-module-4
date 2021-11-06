package com.codegym.controller;

import com.codegym.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;





@Controller
@RequestMapping (value = {"","/","start"})
public class RestaurantCotroller {
    @Autowired
    IStaffService staffService;


    @GetMapping("/admin")
    public ModelAndView goLogin () {
        ModelAndView modelAndView = new ModelAndView("/admin");
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView goHome () {
        ModelAndView modelAndView = new ModelAndView("/home");
        return modelAndView;
    }

    @GetMapping ("/profile")
    public ModelAndView goProfile () {
        ModelAndView modelAndView = new ModelAndView("/profile");
        return modelAndView;
    }





}
