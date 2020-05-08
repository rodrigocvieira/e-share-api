package ronjones.share.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ronjones.share.core.share.enuns.SocialNetwork;
import ronjones.share.core.share.exceptions.SocialNetworkException;
import ronjones.share.core.share.interfaces.ShareSocialNetworkSend;
import ronjones.share.socialnetwork.facebook.Facebook;
import ronjones.share.socialnetwork.instagram.Instagram;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ShareFactoryTest {

    @InjectMocks
    private ShareFactory shareFactory;

    @Mock
    private Facebook facebookApi;

    @Mock
    private Instagram instagramApi;

    @Test
    public void buildExecuteFacebook() {
        ShareSocialNetworkSend build = shareFactory.build(SocialNetwork.FACEBOOK);
        assertTrue(build instanceof Facebook);
    }

    @Test
    public void buildExecuteInstagram() {
        ShareSocialNetworkSend build = shareFactory.build(SocialNetwork.INSTAGRAM);
        assertTrue(build instanceof Instagram);
    }

    @Test(expected = SocialNetworkException.class)
    public void notFound() {
        shareFactory.build(SocialNetwork.TWITTER);
    }

}