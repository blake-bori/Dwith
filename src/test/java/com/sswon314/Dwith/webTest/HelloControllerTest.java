package com.sswon314.Dwith.webTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc; // 웹 테스트할 때 사용, HTTP GEt/POST 등에 대한 API 테스트를 할 수 있다

    @Test
    public void returnHello() throws Exception {
        String hello = "hello!";

        mvc.perform(get("/hello")) // /hello 주소로 GET 요청을 한다
                .andExpect(status().isOk()) // HTTP header의 status를 검증 (여기서는 200인지 아닌지 확인)
                .andExpect(content().string(hello)); // Controller에서 "hello!"를 리턴하기 때문에 이 값이 맞는지 확인
    }

    @Test
    public void returnHelloDto() throws Exception {
        String name = "hello!";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}