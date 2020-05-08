package ronjones.share.socialnetwork.instagram;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ronjones.share.core.share.ShareRequest;
import ronjones.share.core.share.ShareResponse;
import ronjones.share.socialnetwork.facebook.FacebookRequest;
import ronjones.share.socialnetwork.facebook.FacebookResponse;
import ronjones.share.socialnetwork.instagram.api.InstagramApi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InstagramTest {

    @InjectMocks
    private Instagram facebook;

    @Mock
    private InstagramApi instagramApi;

    @Test
    public void executeSuccess() {
        InstagramResponse instagramResponse = new InstagramResponse();
        instagramResponse.setUuid("01");

        when(instagramApi.send(any(InstagramRequest.class))).thenReturn(instagramResponse);

        ShareRequest shareRequest = new ShareRequest();
        shareRequest.setEmail("email@email.com");
        shareRequest.setMessage("message");

        ShareResponse response = facebook.execute(shareRequest).block();

        assert response != null;
        assertEquals(instagramResponse.getUuid(), response.getUuid());
        verify(instagramApi).send(any(InstagramRequest.class));
    }
}