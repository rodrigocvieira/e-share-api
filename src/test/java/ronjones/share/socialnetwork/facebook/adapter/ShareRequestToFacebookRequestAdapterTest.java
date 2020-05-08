package ronjones.share.socialnetwork.facebook.adapter;

import org.junit.Before;
import org.junit.Test;
import ronjones.share.core.share.ShareRequest;
import ronjones.share.socialnetwork.facebook.FacebookRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShareRequestToFacebookRequestAdapterTest {

    private ShareRequestToFacebookRequestAdapter shareRequestToFacebookRequestAdapter;

    @Before
    public void init() {
        shareRequestToFacebookRequestAdapter = new ShareRequestToFacebookRequestAdapter();
    }

    @Test
    public void convert() {
        ShareRequest shareRequest = new ShareRequest();
        shareRequest.setMessage("Oi Mundo");
        shareRequest.setEmail("email@email.com");
        shareRequest.setLinkPhoto("https://nenhum.com.br");

        FacebookRequest facebookRequest = shareRequestToFacebookRequestAdapter.convert(shareRequest);
        assertEquals(shareRequest.getEmail(), facebookRequest.getEmail());
        assertEquals(shareRequest.getLinkPhoto(), facebookRequest.getLinkPhoto());
        assertEquals(shareRequest.getMessage(), facebookRequest.getMessage());
    }
}