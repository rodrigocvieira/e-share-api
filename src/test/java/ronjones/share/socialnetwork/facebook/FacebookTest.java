package ronjones.share.socialnetwork.facebook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ronjones.share.core.share.ShareRequest;
import ronjones.share.core.share.ShareResponse;
import ronjones.share.socialnetwork.facebook.api.FacebookApi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FacebookTest {

    @InjectMocks
    private Facebook facebook;

    @Mock
    private FacebookApi facebookApi;

    @Test
    public void executeSuccess() {
        FacebookResponse facebookResponse = new FacebookResponse();
        facebookResponse.setUuid("01");

        when(facebookApi.send(any(FacebookRequest.class))).thenReturn(facebookResponse);

        ShareRequest shareRequest = new ShareRequest();
        shareRequest.setEmail("email@email.com");
        shareRequest.setMessage("message");

        ShareResponse response = facebook.execute(shareRequest).block();

        assert response != null;
        assertEquals(facebookResponse.getUuid(), response.getUuid());
        verify(facebookApi).send(any(FacebookRequest.class));
    }
}