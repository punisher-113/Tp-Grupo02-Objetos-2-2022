package com.trabajo.Grupo02OO22022;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Mvconfig implements WebMvcConfigurer {

    @Bean
    public BCryptPasswordEncoder passEncoder() {

        return new BCryptPasswordEncoder();
    }

}
