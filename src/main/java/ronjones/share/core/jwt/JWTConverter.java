package ronjones.share.core.jwt;

import com.google.gson.Gson;
import ronjones.share.core.auth.ShareToken;
import ronjones.share.core.auth.Token;

import java.util.Base64;
import java.util.Calendar;

public class JWTConverter {

    public static ShareToken convert(String token) {
        String[] split_string = token.split("\\.");

        String base64EncodedBody = split_string[1];
        String body = new String(Base64.getDecoder().decode(base64EncodedBody));

        Gson g = new Gson();
        return convertShareToken(g.fromJson(body, Token.class));
    }

    private static ShareToken convertShareToken(Token token) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(token.getIat()*1000);
        return new ShareToken(instance.getTime());
    }
}
