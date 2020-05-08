package ronjones.share.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ronjones.share.core.decorator.ShareDecorator;
import ronjones.share.core.service.PublishService;
import ronjones.share.core.share.ShareRequest;
import ronjones.share.core.share.ShareResponse;
import ronjones.share.core.share.enuns.SocialNetwork;
import ronjones.share.factory.ShareFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PublishServiceTest {

    @InjectMocks
    private PublishService publishService;

    @Mock
    private ShareFactory shareFactory;

    @Test
    public void sendSuccess() {
        ShareDecorator shareDecoratorFacebook = mock(ShareDecorator.class);
        ShareDecorator shareDecoratorInstagram = mock(ShareDecorator.class);

        ShareRequest shareRequest = new ShareRequest();
        shareRequest.setEmail("teste@teste.com");
        shareRequest.setMessage("Ok");
        shareRequest.setSocialNetworkLists(Arrays.asList(SocialNetwork.FACEBOOK, SocialNetwork.INSTAGRAM));

        when(shareFactory.build(SocialNetwork.FACEBOOK)).thenReturn(shareDecoratorFacebook);
        ShareResponse shareResponseFacebook = new ShareResponse();
        shareResponseFacebook.setUuid("01");
        when(shareDecoratorFacebook.execute(shareRequest)).thenReturn(Mono.just(shareResponseFacebook));

        when(shareFactory.build(SocialNetwork.INSTAGRAM)).thenReturn(shareDecoratorInstagram);
        ShareResponse shareResponseInstagram = new ShareResponse();
        shareResponseInstagram.setUuid("01");
        when(shareDecoratorInstagram.execute(shareRequest)).thenReturn(Mono.just(shareResponseInstagram));

        List<ShareResponse> shareResponseList = publishService.send(shareRequest).collectList().block();

        assert shareResponseList != null;
        for (ShareResponse response : shareResponseList) {
            assertNotNull(response.getUuid());
        }
    }

    @Test
    public void sendNotFoundNetwork() {
        ShareRequest shareRequest = new ShareRequest();
        shareRequest.setEmail("teste@teste.com");
        shareRequest.setMessage("Ok");
        shareRequest.setSocialNetworkLists(Collections.singletonList(SocialNetwork.TWITTER));
        Flux<ShareResponse> response = publishService.send(shareRequest);
        StepVerifier.create(response).verifyError();
    }
}