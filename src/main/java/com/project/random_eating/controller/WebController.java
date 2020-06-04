package com.project.random_eating.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WebController {
    @GetMapping("/")
    public ModelAndView index()  {
        return new ModelAndView("/RandomInfo");
    }

    @GetMapping("/showAll")
    public ModelAndView showList() {
        return new ModelAndView("/ShowList");
    }

    @GetMapping("/showHistory")
    public ModelAndView showHistory() {
        return new ModelAndView("/History");
    }

    @GetMapping("/newOne")
    public ModelAndView newOne() {
        return new ModelAndView("/NewOne");
    }
}