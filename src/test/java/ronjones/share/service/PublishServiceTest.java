package ronjones.share.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import ronjones.share.common.share.ShareRequest;
import ronjones.share.common.share.ShareResponse;
import ronjones.share.common.share.enuns.SocialNetwork;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class PublishServiceTest {

    @InjectMocks
    private PublishService publishService;

    @Test
    public void sendSuccess() {
        ShareRequest shareRequest = new ShareRequest();
        shareRequest.setEmail("teste@teste.com");
        shareRequest.setMessage("Ok");
        shareRequest.setSocialNetworkLists(Arrays.asList(SocialNetwork.FACEBOOK, SocialNetwork.INSTAGRAM));
        List<ShareResponse> shareResponseList = publishService.send(shareRequest).collectList().block();

        assert shareResponseList != null;
        for (ShareResponse response : shareResponseList) {
            assertNotNull(response.getUuid());
        }
    }

}