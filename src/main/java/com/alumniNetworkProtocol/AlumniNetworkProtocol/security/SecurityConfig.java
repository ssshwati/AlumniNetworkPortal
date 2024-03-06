package com.alumniNetworkProtocol.AlumniNetworkProtocol.security;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.Enum.Role;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.services.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private  JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private  UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/auth/admin").hasAnyAuthority(Role.ADMIN.name())
//                .antMatchers("/auth/user").hasAnyAuthority(Role.USER.name())
//                .anyRequest().authenticated()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/signup", "/auth/signin").permitAll() // Allow access to /auth/signup without authentication
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService.userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}



//package com.alumniNetworkProtocol.AlumniNetworkProtocol.security;
//
//import com.alumniNetworkProtocol.AlumniNetworkProtocol.Enum.Role;
//import com.alumniNetworkProtocol.AlumniNetworkProtocol.services.api.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
////@RequiredArgsConstructor
//public class SecurityConfig {
//    private JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    private final  UserService userService;
//
//    public SecurityConfig(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(request -> request
//                        .antMatchers("/auth/admin").hasAnyAuthority(Role.ADMIN.name())
//                        .antMatchers("/auth/user").hasAnyAuthority(Role.USER.name())
//                        .anyRequest().authenticated())
//                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider())
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider () {
//            DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//            authenticationProvider.setUserDetailsService(userService.userDetailsService());
//            authenticationProvider.setPasswordEncoder(passwordEncoder());
//            return authenticationProvider;
//        }
//
//            @Bean
//            public PasswordEncoder passwordEncoder () {
//                return new BCryptPasswordEncoder();
//            }
//
//
//            @Bean
//            public AuthenticationManager authenticationManager (AuthenticationConfiguration config) throws Exception {
//                return config.getAuthenticationManager();
//            }
//
//
//    }
//
//
//
//
//
////@Configuration
////@EnableWebSecurity
////@RequiredArgsConstructor
////public class SecurityConfig extends WebSecurityConfigurerAdapter {
////  private  JwtAuthenticationFilter jwtAuthenticationFilter;
////  private  UserService userService;
////
////  @Override
////  protected void configure(HttpSecurity http) throws Exception {
////      http.csrf().disable()
////              .authorizeRequests()
////              .antMatchers("/auth/admin").hasAuthority(Role.ADMIN.name())
////              .antMatchers("/auth/user").hasAuthority(Role.USER.name())
////              .anyRequest().authenticated()
////              .and()
////              .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////              .and()
////              .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
////  }
////
////  @Bean
////  public PasswordEncoder passwordEncoder() {
////      return new BCryptPasswordEncoder();
////  }
////}