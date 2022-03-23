package com.rest.blog.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.rest.blog.util.Constantes.AUTH_WHITELIST;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//.antMatchers("/swagger-ui/**").permitAll()
                .antMatchers("/usuario/login/**").permitAll().and()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/usuario/login/").permitAll().and()
                .authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
                //.antMatchers("/**").permitAll()
                .anyRequest().authenticated().and().
                addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
