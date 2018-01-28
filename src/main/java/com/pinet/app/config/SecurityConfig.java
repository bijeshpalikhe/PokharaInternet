package com.pinet.app.config;

import com.pinet.app.security.web.LoggingAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("M at Httpsecurity Configure");
        http.csrf().disable().authorizeRequests()
                .antMatchers(
                        "/assets/images/**",
                        "/assets/plugins/**",
                        "/assets/plugins/bootstrap-material-datetimepicker/**",
                        "/assets/plugins/bootstrap-material-datetimepicker/**",
                        "/assets/plugins/moment/**",
                        "/assets/plugins/datatables/**",
                        "/assets/plugins/moment/min/**",
                        "/assets/css/**",
                        "/assets/js/**",
                        "/**/assets/**"
                ).permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/**/assets/**").permitAll()
                .antMatchers("/**/employeeinfo/**").authenticated()
                .antMatchers("/**/userdata/**").authenticated()
                .antMatchers("/**/client/**").authenticated()
                .antMatchers("/**/sms/**").authenticated()
                .antMatchers("/**/ticket/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard", true)
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("**/assets/**");
    }
}