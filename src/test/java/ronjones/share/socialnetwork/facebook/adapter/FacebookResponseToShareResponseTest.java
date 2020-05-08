package ronjones.share.socialnetwork.facebook.adapter;

import org.junit.Before;
import org.junit.Test;
import ronjones.share.core.share.ShareResponse;
import ronjones.share.socialnetwork.facebook.FacebookResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FacebookResponseToShareResponseTest {

    private FacebookResponseToShareResponse facebookResponseToShareResponse;

    @Before
    public void init() {
        facebookResponseToShareResponse = new FacebookResponseToShareResponse();
    }

    @Test
    public void convert() {
        FacebookResponse facebookResponse = new FacebookResponse();
        facebookResponse.setUuid("01");
        ShareResponse shareResponse = facebookResponseToShareResponse.convert(facebookResponse);
        assertEquals(facebookResponse.getUuid(), shareResponse.getUuid());
    }

}