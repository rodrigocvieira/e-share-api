package ronjones.share.socialnetwork.instagram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import ronjones.share.core.decorator.ShareDecorator;
import ronjones.share.core.share.ShareRequest;
import ronjones.share.core.share.ShareResponse;
import ronjones.share.core.share.interfaces.ShareSocialNetworkSend;
import ronjones.share.socialnetwork.instagram.adapter.InstagramResponseToShareResponse;
import ronjones.share.socialnetwork.instagram.adapter.ShareRequestToInstagramRequestAdapter;
import ronjones.share.socialnetwork.instagram.api.InstagramApi;

@Component
public class Instagram implements ShareSocialNetworkSend {

    private final InstagramApi instagramApi;

    @Autowired
    public Instagram(InstagramApi instagramApi) {
        this.instagramApi = instagramApi;
    }

    @Override
    public Mono<ShareResponse> execute(ShareRequest request) {
        ShareDecorator<InstagramResponse, InstagramRequest> send = new ShareDecorator<>(
                new ShareRequestToInstagramRequestAdapter(),
                new InstagramResponseToShareResponse(),
                instagramApi
        );

        return send.execute(request);
    }
}
