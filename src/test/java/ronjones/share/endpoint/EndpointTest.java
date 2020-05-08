package ronjones.share.endpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import ronjones.share.common.share.ShareRequest;
import ronjones.share.common.share.enuns.SocialNetwork;

import java.util.Arrays;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
public class EndpointTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void success() {
        ShareRequest shareRequest = new ShareRequest();
        shareRequest.setEmail("email@teste.com");
        shareRequest.setLinkPhoto("http//asok.com.br");
        shareRequest.setMessage("message");
        shareRequest.setSocialNetworkLists(Arrays.asList(SocialNetwork.FACEBOOK, SocialNetwork.INSTAGRAM));

        WebTestClient.ResponseSpec response = endpoint(shareRequest);
        response.expectStatus().is2xxSuccessful();
    }

    @Test
    public void error() {
        ShareRequest shareRequest = new ShareRequest();
        shareRequest.setEmail("email@teste.com");
        shareRequest.setLinkPhoto("http//asok.com.br");
        shareRequest.setMessage("message");
        shareRequest.setSocialNetworkLists(Collections.singletonList(SocialNetwork.TWITTER));

        WebTestClient.ResponseSpec response = endpoint(shareRequest);
        response.expectStatus().is5xxServerError();
    }


    private WebTestClient.ResponseSpec endpoint(ShareRequest request) {
        return webTestClient.post()
                .uri("/v1/publish")
                .body(Mono.just(request), ShareRequest.class)
                .exchange();
    }
}