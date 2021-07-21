package org.jx.vhr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jx.vhr.model.Hr;
import org.jx.vhr.model.RespBean;
import org.jx.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    HrService hrService;
    @Autowired
    CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
    @Autowired
    CustomUrlDecisionManager customUrlDecisionManager;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/login");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
 //               .anyRequest().authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setAccessDecisionManager(customUrlDecisionManager);
                        object.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
                        return object;
                    }
                })
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/doLogin")
                .loginPage("/login")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp,Authentication auth) throws IOException, ServletException
                    {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out=resp.getWriter();
                        Hr hr=(Hr)auth.getPrincipal();
                        hr.setPassword(null);
                        RespBean ok = RespBean.ok("Success Login!", hr);
                        String s = new ObjectMapper().writeValueAsString(hr);
                        out.write(s);
                        out.flush();
                        out.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler(){
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp,AuthenticationException e) throws IOException, ServletException
                    {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out=resp.getWriter();
                        RespBean respBean = RespBean.error("Fail Login!");
                        if(e instanceof LockedException){
                            respBean.setMsg("The account is locked, please contact the administrator!");
                        }else if(e instanceof CredentialsExpiredException){
                            respBean.setMsg("The password is not valid, please contact the administrator!");
                        }else if(e instanceof AccountExpiredException){
                            respBean.setMsg("The account is not valid, please contact the administrator!");
                        }else if(e instanceof DisabledException){
                            respBean.setMsg("The account is not permit, please contact the administrator!");
                        }else if(e instanceof BadCredentialsException){
                            respBean.setMsg("The account or password is wrong!");
                        }
                        out.write(new ObjectMapper().writeValueAsString(respBean));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out=resp.getWriter();
                        Hr hr=(Hr)auth.getPrincipal();
                        RespBean ok = RespBean.ok("You have logged out!", hr);
                        String s = new ObjectMapper().writeValueAsString(ok);
                        out.write(s);
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .csrf().disable().exceptionHandling()
                //when No authentication, handle here.no redirect
                .authenticationEntryPoint(new AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                resp.setContentType("application/json;charset=utf-8");
                resp.setStatus(401);
                PrintWriter out=resp.getWriter();
                RespBean respBean = RespBean.error("Fail access!");
                if(e instanceof InsufficientAuthenticationException){
                    respBean.setMsg("Illegal request! Please contact administrator!");
                }
                out.write(new ObjectMapper().writeValueAsString(respBean));
                out.flush();
                out.close();
            }
        });
    }
}
