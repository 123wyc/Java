package com.example.wyc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {

    @RequestMapping("/index")
    public String home(){
        return "index";
    }
}
