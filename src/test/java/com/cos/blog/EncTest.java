package com.cos.blog;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncTest
{
    @Test
    public void 해쉬_암호화(){
        String encPassowrd = new BCryptPasswordEncoder().encode("1234");
        System.out.println("1234 해쉬 : " + encPassowrd);
    }

    @Test
    public void 테스트(){
        System.out.println("ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
    }
}
