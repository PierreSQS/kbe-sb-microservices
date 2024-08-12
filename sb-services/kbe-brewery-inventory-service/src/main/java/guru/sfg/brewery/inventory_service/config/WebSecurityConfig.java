package guru.sfg.brewery.inventory_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Modified by Pierrot on 2024-08-12.
 */
@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        HttpSecurity httpSecurity = http.authorizeHttpRequests(authorize ->
                        authorize.requestMatchers("/actuator/health/**").permitAll()
                                .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);


//        HttpSecurity httpSecurity1 = http.securityMatcher(EndpointRequest.toAnyEndpoint())
//                .authorizeHttpRequests(authorize ->
//                        authorize.anyRequest().permitAll())
//                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }
}