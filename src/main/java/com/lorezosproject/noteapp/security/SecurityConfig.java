package com.lorezosproject.noteapp.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //adding support for jdbc authentication
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }


    //adding the path to secure
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configure ->
            configure
                .requestMatchers("/", "/login", "/authenticateTheUser", "/landing-page", "/register", "/css/**").permitAll() 
                .requestMatchers("/home-page").hasRole("USER")
                .anyRequest().authenticated()
                )
                
                .formLogin(Customizer.withDefaults())

                .logout(logout -> logout
                    .permitAll())


                .exceptionHandling(cofing -> cofing
                    .accessDeniedPage("/access-denied"))
                ;

        //disabling csrf
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    //adding the code for password encryption
    @Bean 
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
