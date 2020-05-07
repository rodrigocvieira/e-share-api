package ronjones.share.socialnetwork.facebook.api;

import org.junit.Before;
import org.junit.Test;
import ronjones.share.socialnetwork.facebook.FacebookRequest;
import ronjones.share.socialnetwork.facebook.FacebookResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FacebookApiTest {

    private FacebookApi facebookApi;

    @Before
    public void init() {
        facebookApi = new FacebookApi();
    }

    @Test
    public void send() {
        FacebookResponse facebookResponse = facebookApi.send(new FacebookRequest());
        assertNotNull(facebookResponse);
        assertNotNull(facebookResponse.getUuid());
    }

}