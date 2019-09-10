package com.game.game_2048.configuration;

import com.game.game_2048.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Autowired
//    CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;

    @Bean
    public UserDetailsService mongoUserDetails() {
        return new CustomUserDetailsService();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//    necessary to prevent security from being applied to the resources
//    such as CSS, images and javascripts
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/templates/**", "/css/**", "/js/**", "/images/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        UserDetailsService userDetailsService = mongoUserDetails();

        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);

//        auth.
//                jdbcAuthentication()
//                .usersByUsernameQuery(usersQuery)
//                .authoritiesByUsernameQuery(rolesQuery)
//                .dataSource(dataSource)
//                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/dashboard/**").hasAuthority("ADMIN").anyRequest()
//                .authenticated().and().csrf().disable().formLogin().successHandler(customizeAuthenticationSuccessHandler)

                .authenticated()
                .and()
                .csrf().disable().
                formLogin()


                .loginPage("/login").failureUrl("/login?error=true")
                .usernameParameter("email")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling();


//        http
//                .authorizeRequests()
//                .antMatchers("/user/all", "/registration").permitAll()
////                .antMatchers("/admin/**").access("hasAnyAuthority('ADMIN')")
////                .antMatchers("/user/**").hasAnyAuthority("USER", "ADMIN")
////                .antMatchers("/lib/**").hasAnyAuthority("ADMIN", "LIBRARIAN")
////                .anyRequest().authenticated()
//                .and()
//                .csrf().disable()
//                .formLogin().loginPage("/login").permitAll()
//                .defaultSuccessUrl("/dashboard", true)
//                .failureUrl("/login?error=True")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .and()
//                .logout().permitAll().logoutSuccessUrl("/?Logout")
//                .and()
//                .exceptionHandling().accessDeniedPage("/access-denied");
    }

}
