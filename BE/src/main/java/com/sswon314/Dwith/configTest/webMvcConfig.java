package com.sswon314.Dwith.configTest;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webMvcConfig implements WebMvcConfigurer {
    
    // localhost:8080은 cors 오류 안뜨게 오리진 허용을 시켜준다
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                // allowedMethods는 기본값이 get, head, post인데 put, delete를 추가로 설정해줘야 put, delete의 cors 오류가 안뜬다
                .allowedMethods(HttpMethod.GET.name(), HttpMethod.HEAD.name(), HttpMethod.POST.name(), HttpMethod.PUT.name(), HttpMethod.DELETE.name());
    }
}
