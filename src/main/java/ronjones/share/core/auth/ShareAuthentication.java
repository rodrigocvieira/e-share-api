package ronjones.share.core.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.stereotype.Component;

@Component
public class ShareAuthentication extends AuthenticationWebFilter {

    @Autowired
    public ShareAuthentication(ShareAuth authenticationManager,
                               ShareTokenMatcher shareTokenMatcher,
                               ShareAuthConverter shareAuthConverter) {
        super(authenticationManager);
        setRequiresAuthenticationMatcher(shareTokenMatcher);
        setServerAuthenticationConverter(shareAuthConverter::apply);
    }
}


