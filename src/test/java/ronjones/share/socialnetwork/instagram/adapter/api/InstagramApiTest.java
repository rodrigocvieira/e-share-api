package ronjones.share.socialnetwork.instagram.adapter.api;

import org.junit.Before;
import org.junit.Test;
import ronjones.share.socialnetwork.instagram.InstagramRequest;
import ronjones.share.socialnetwork.instagram.InstagramResponse;
import ronjones.share.socialnetwork.instagram.api.InstagramApi;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InstagramApiTest {

    private InstagramApi instagramApi;

    @Before
    public void init() {
        instagramApi = new InstagramApi();
    }

    @Test
    public void send() {
        InstagramResponse instagramResponse = instagramApi.send(new InstagramRequest());
        assertNotNull(instagramResponse);
        assertNotNull(instagramResponse.getUuid());
    }

}