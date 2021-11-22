package com.example.foodorderingapplication.Security;

import javax.servlet.Filter;

import com.example.foodorderingapplication.PasswordEncoder;
import com.example.foodorderingapplication.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder pwEncoder;
    
    @Autowired
    UserDetailsService udService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(udService).passwordEncoder(pwEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests().antMatchers("/public/**").permitAll();

        http.authorizeRequests().antMatchers("/admin/**").hasAnyAuthority(Role.ADMIN.toString());
        http.authorizeRequests().antMatchers("/customer/**").hasAnyAuthority(Role.CUSTOMER.toString());

        http.authorizeRequests().anyRequest().authenticated();

        
        AuthenticationFilter AuthFilter = new AuthenticationFilter();
        AuthFilter.setAuthenticationManager( this.authenticationManager() );
        http.addFilter((Filter) AuthFilter);

        http.addFilterBefore((Filter) new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }
    
}
