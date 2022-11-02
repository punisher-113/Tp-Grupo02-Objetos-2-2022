package com.trabajo.Grupo02OO22022;

import javax.sql.DataSource;

import com.trabajo.Grupo02OO22022.util.LoginSuccessMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder passEncoder;
    @Autowired
    private LoginSuccessMessage loginSuccess;

    @Autowired
    public void configurerSecurityGlobar(AuthenticationManagerBuilder builder) throws Exception {

        builder.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passEncoder)
                .usersByUsernameQuery(
                        "SELECT username, password, u.enabled FROM user u inner join persona p on u.id = p.id where username =?")
                .authoritiesByUsernameQuery(
                        "Select u.username, r.descripcion FROM role r inner join user u on r.id=u.role_id where u.username=?");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Configuracion de http para acceso publico
        http.authorizeRequests()
                .antMatchers("/", "/home", "/index", "/css/**", "/js/**", "/images/**", "/views/roles/**",
                        "/views/users/**", "/edificios/**")
                .permitAll().anyRequest()
                .authenticated().and().formLogin()
                .successHandler(loginSuccess)
                .loginPage("/login")
                .permitAll().and().logout().logoutUrl("/logout").logoutSuccessUrl("/logout").permitAll();

    }

}
