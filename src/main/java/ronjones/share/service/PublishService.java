package ronjones.share.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ronjones.share.common.share.ShareRequest;
import ronjones.share.common.share.ShareResponse;
import ronjones.share.decorator.ShareDecorator;
import ronjones.share.socialnetwork.facebook.FacebookRequest;
import ronjones.share.socialnetwork.facebook.FacebookResponse;
import ronjones.share.socialnetwork.facebook.adapter.FacebookResponseToShareResponse;
import ronjones.share.socialnetwork.facebook.adapter.ShareRequestToFacebookRequestAdapter;
import ronjones.share.socialnetwork.facebook.api.FacebookApi;

@Service
public class PublishService {
    public Mono<ShareResponse> send(ShareRequest request) {
        ShareDecorator<FacebookResponse, FacebookRequest> shareDecorator = new ShareDecorator<>(
                new ShareRequestToFacebookRequestAdapter(),
                new FacebookResponseToShareResponse(),
                new FacebookApi()
        );

        return shareDecorator.run(request);
    }
}
