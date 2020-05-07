package ronjones.share.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import ronjones.share.common.share.ShareRequest;
import ronjones.share.common.share.ShareResponse;

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
        ShareResponse shareResponse = publishService.send(shareRequest).block();
        assertNotNull(shareResponse.getUuid());
    }

}