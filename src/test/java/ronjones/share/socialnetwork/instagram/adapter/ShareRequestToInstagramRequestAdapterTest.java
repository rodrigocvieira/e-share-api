package ronjones.share.socialnetwork.instagram.adapter;

import org.junit.Before;
import org.junit.Test;
import ronjones.share.common.share.ShareRequest;
import ronjones.share.socialnetwork.instagram.InstagramRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShareRequestToInstagramRequestAdapterTest {

    private ShareRequestToInstagramRequestAdapter shareRequestToInstagramRequestAdapter;

    @Before
    public void init() {
        shareRequestToInstagramRequestAdapter = new ShareRequestToInstagramRequestAdapter();
    }

    @Test
    public void convert() {
        ShareRequest shareRequest = new ShareRequest();
        shareRequest.setMessage("Oi Mundo");
        shareRequest.setEmail("email@email.com");
        shareRequest.setLinkPhoto("https://nenhum.com.br");

        InstagramRequest instagramRequest = shareRequestToInstagramRequestAdapter.convert(shareRequest);
        assertEquals(shareRequest.getEmail(), instagramRequest.getEmail());
        assertEquals(shareRequest.getLinkPhoto(), instagramRequest.getLinkPhoto());
        assertEquals(shareRequest.getMessage(), instagramRequest.getMessage());
    }
}