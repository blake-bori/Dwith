package com.sswon314.Dwith.webTest;

import com.sswon314.Dwith.serviceTest.PostsService;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController implements ErrorController {

    // private final PostsService postsService;

    // spa 새로고침 시 index.html 반환
    @GetMapping({"/", "/error"})
    public String redirectRoot() {
        return "index.html";
    }

    // 에러 페이지시 /error 반환
    public String getErrorPath() {
        return "/error";
    }
}
