package com.sswon314.Dwith.webTest.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombokTest(){
        String name="test";
        int amount=1000;

        HelloResponseDto dto=new HelloResponseDto(name,amount);

        // assertThat : 검증하고 싶은 대상을 메소드 인자로 받고 isEqualTo와 같이 메소드를 이어서 사용 가능
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
