package ronjones.share.socialnetwork.instagram.adapter;

import org.junit.Before;
import org.junit.Test;
import ronjones.share.common.share.ShareResponse;
import ronjones.share.socialnetwork.instagram.InstagramResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstagramResponseToShareResponseTest {

    private InstagramResponseToShareResponse instagramResponseToShareResponse;

    @Before
    public void init() {
        instagramResponseToShareResponse = new InstagramResponseToShareResponse();
    }

    @Test
    public void convert() {
        InstagramResponse instagramResponse = new InstagramResponse();
        instagramResponse.setUuid("01");
        ShareResponse shareResponse = instagramResponseToShareResponse.convert(instagramResponse);
        assertEquals(instagramResponse.getUuid(), shareResponse.getUuid());
    }

}