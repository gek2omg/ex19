package com.example.ex19.htmltest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmltestController {


    @GetMapping("/test/form")
    public String testForm() {

        return "testform";
    }
}
