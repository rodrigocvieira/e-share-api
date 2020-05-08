package ronjones.share.core.auth;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class ShareAuthConverter implements Function<ServerWebExchange, Mono<Authentication>> {

    @Override
    public Mono<Authentication> apply(ServerWebExchange serverWebExchange) {
        return Mono.just(serverWebExchange)
                .map(ServerWebExchange::getRequest)
                .map(ServerHttpRequest::getHeaders)
                .map(h -> h.getFirst("Authorization"))
                .map(ShareAuthenticationToken::new);
    }
}
