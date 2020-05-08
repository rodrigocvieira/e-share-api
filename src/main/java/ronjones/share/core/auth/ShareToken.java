package ronjones.share.core.auth;

import java.util.Date;

public class ShareToken {

    private Date expiryDate;

    public ShareToken(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isTokenExpired(){
        return expiryDate.before(new Date());
    }
}
