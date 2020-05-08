package ronjones.share.core.auth;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import ronjones.share.core.jwt.JWTConverter;

@Component
public class ShareAuth implements ReactiveAuthenticationManager {

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        ShareAuthenticationToken shareAuthenticationToken = (ShareAuthenticationToken) authentication;

        String token = shareAuthenticationToken.getCredentials().substring(7);
        ShareToken shareToken = JWTConverter.convert(token);

        authentication.setAuthenticated(!shareToken.isTokenExpired());
        return Mono.just(authentication);
    }
}
