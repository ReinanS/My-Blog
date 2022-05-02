package edu.com.pweb.newsblog.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.com.pweb.newsblog.service.MyBlogUserDetailService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private final MyBlogUserDetailService myBlogUserDetailService;

    // Autenticacao
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myBlogUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }

    // Recursos Estáticos
    @Override
    public void configure(WebSecurity web) throws Exception {

    }

    // Autorizacao
    // O que estou protegendo com o protocolo http
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
       .antMatchers(HttpMethod.GET, "/posts**").permitAll()
       .anyRequest().authenticated()
       .and().formLogin();
    }

    public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}
    
}
