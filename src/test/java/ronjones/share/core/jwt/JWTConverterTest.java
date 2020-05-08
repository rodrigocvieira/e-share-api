package ronjones.share.core.jwt;

import org.junit.Test;
import ronjones.share.TokenEnum;
import ronjones.share.core.auth.ShareToken;

import java.text.ParseException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JWTConverterTest {

    @Test
    public void convertTokenExpired() {
        ShareToken token = JWTConverter.convert(TokenEnum.INVALID.getValue());
        assertTrue(token.isTokenExpired());
    }

    @Test
    public void convertSucess() throws ParseException {
        ShareToken token = JWTConverter.convert(TokenEnum.VALID.getValue());
        assertFalse(token.isTokenExpired());
    }
}