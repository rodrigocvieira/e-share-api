package ronjones.share.core.auth.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import ronjones.share.core.auth.ShareAuthentication;

@EnableWebFluxSecurity
public class WebFluxSecurityConfig {

    private final ReactiveAuthenticationManager authenticationManager;

    private final ShareAuthentication shareAuthentication;

    @Autowired
    public WebFluxSecurityConfig(ReactiveAuthenticationManager authenticationManager,
                                 ShareAuthentication shareAuthentication) {
        this.authenticationManager = authenticationManager;
        this.shareAuthentication = shareAuthentication;
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .addFilterAt(shareAuthentication, SecurityWebFiltersOrder.AUTHENTICATION)
                .authorizeExchange()
                .anyExchange().authenticated()
                .and()
                .formLogin().disable()
                .csrf().disable()
                .httpBasic().disable()
                .logout().disable()
                .authenticationManager(authenticationManager)
                .build();
    }
}