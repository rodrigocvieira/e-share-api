package ronjones.share.core.auth;


import org.springframework.security.authentication.AbstractAuthenticationToken;

public class ShareAuthenticationToken extends AbstractAuthenticationToken {

    private String token;

    public ShareAuthenticationToken(String bearerToken) {
        super(null);
        this.token = bearerToken;
    }

    @Override
    public String getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}