package br.laelmartinez.springsecuritygoogle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Tanto authorizeConfig quanto authorizeRequests podem ser usados para obter uma configuração simplificada 
        // de autorização de requisições do Spring Security.
       
        http
            .authorizeHttpRequests(
                authorizeConfig -> {
                    
                    authorizeConfig.requestMatchers("/public").permitAll();
                    authorizeConfig.requestMatchers("/private").authenticated();
                    authorizeConfig.anyRequest().authenticated();

                }
            )
            .oauth2Login(Customizer.withDefaults())

            .oauth2ResourceServer(
                config -> config.jwt( Customizer.withDefaults() )  
                );

            
        return http.build();


        /* 
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                .requestMatchers("/public").permitAll()
                .requestMatchers("/private").authenticated()
                .anyRequest().authenticated()
            ).formLogin(Customizer.withDefaults());
        return http.build();
        */
    }




}
