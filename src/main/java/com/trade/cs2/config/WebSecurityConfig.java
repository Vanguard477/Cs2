package com.trade.cs2.config;


import com.trade.cs2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    UserService userService;

    /*  @Bean
      public UserDetailsService userDetailsService(PasswordEncoder encoder) {
          UserDetails admin = User.builder().username("admin").password(encoder.encode("admin")).build();
          UserDetails user = User.builder().username("user").password(encoder.encode("user")).build();
          UserDetails danil = User.builder().username("danil").password(encoder.encode("danil")).build();
          return new InMemoryUserDetailsManager(admin, user, danil);
      }

     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.requestMatchers("/", "/trade", "/about").permitAll()
                        .requestMatchers("/profile", "/trade/{id}", "/trade/add", "/trade/{id}/edit", "/trade/{id}/remove").authenticated())
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll).build();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }


}








