package ronjones.share.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ronjones.share.core.decorator.ShareDecorator;
import ronjones.share.core.share.ShareRequest;
import ronjones.share.core.share.enuns.SocialNetwork;
import ronjones.share.core.share.exceptions.SocialNetworkException;
import ronjones.share.socialnetwork.facebook.FacebookRequest;
import ronjones.share.socialnetwork.facebook.FacebookResponse;
import ronjones.share.socialnetwork.facebook.api.FacebookApi;
import ronjones.share.socialnetwork.instagram.InstagramRequest;
import ronjones.share.socialnetwork.instagram.InstagramResponse;
import ronjones.share.socialnetwork.instagram.api.InstagramApi;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShareFactoryTest {

    @InjectMocks
    private ShareFactory shareFactory;

    @Mock
    private FacebookApi facebookApi;

    @Mock
    private InstagramApi instagramApi;

    @Test
    public void buildExecuteFacebook() {
        when(facebookApi.send(any(FacebookRequest.class))).thenReturn(mock(FacebookResponse.class));
        ShareDecorator<?, ?> build = shareFactory.build(SocialNetwork.FACEBOOK);
        build.execute(mock(ShareRequest.class));
        verify(facebookApi).send(any(FacebookRequest.class));
        verify(instagramApi, never()).send(any(InstagramRequest.class));
    }

    @Test
    public void buildExecuteInstagram() {
        when(instagramApi.send(any(InstagramRequest.class))).thenReturn(mock(InstagramResponse.class));
        ShareDecorator<?, ?> build = shareFactory.build(SocialNetwork.INSTAGRAM);
        build.execute(mock(ShareRequest.class));
        verify(instagramApi).send(any(InstagramRequest.class));
        verify(facebookApi, never()).send(any(FacebookRequest.class));
    }

    @Test(expected = SocialNetworkException.class)
    public void notFound() {
        shareFactory.build(SocialNetwork.TWITTER);
    }

}