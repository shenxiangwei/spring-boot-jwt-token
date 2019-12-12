package com.shenxiangwei.springbootjwttoken.config;

import com.shenxiangwei.redisplugin.cache.RedisClient;
import com.shenxiangwei.springbootjwttoken.filter.JwtAuthenticationTokenFilter;
import com.shenxiangwei.springbootjwttoken.handler.AuthenticationFailureHandlerImpl;
import com.shenxiangwei.springbootjwttoken.handler.AuthenticationSuccessHandlerImpl;
import com.shenxiangwei.springbootjwttoken.security.JwtAuthenticationEntryPoint;
import com.shenxiangwei.springbootjwttoken.service.SelectUserInfoWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private SelectUserInfoWebService selectUserInfoWebService;

    @Autowired
    private JwtAuthenticationEntryPoint entryPoint;

    @Autowired
    private RedisClient redisClient;

    public JwtAuthenticationTokenFilter authenticationTokenFilter() throws Exception {
        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandlerImpl());
        filter.setAuthenticationFailureHandler(new AuthenticationFailureHandlerImpl());
        filter.setRedisClient(redisClient);
        filter.setSelectUserInfoWebService(selectUserInfoWebService);
        return filter;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests().antMatchers("/auth/**").authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();

    }
}
