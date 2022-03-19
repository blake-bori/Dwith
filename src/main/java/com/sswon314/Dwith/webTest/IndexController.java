package com.sswon314.Dwith.webTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save.html";
    }
}
