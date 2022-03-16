package com.sswon314.Dwith.webTest;

import com.sswon314.Dwith.webTest.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 json을 반환하는 컨트롤러로 만들어준다
public class HelloController {

    @GetMapping("/hello") // get요청을 받을 수 있는 API를 만들어 준다
    public String hello() {
        // /hello로 요청이 들어오면 "hello!"를 반환하는 기능
        return "hello!";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name")String name, @RequestParam("amount")int amount){
        return new HelloResponseDto(name,amount);
    }
}
