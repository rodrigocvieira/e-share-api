package ronjones.share.socialnetwork.facebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import ronjones.share.core.decorator.ShareDecorator;
import ronjones.share.core.share.ShareRequest;
import ronjones.share.core.share.ShareResponse;
import ronjones.share.core.share.interfaces.ShareSocialNetworkSend;
import ronjones.share.socialnetwork.facebook.adapter.FacebookResponseToShareResponse;
import ronjones.share.socialnetwork.facebook.adapter.ShareRequestToFacebookRequestAdapter;
import ronjones.share.socialnetwork.facebook.api.FacebookApi;

@Component
public class Facebook implements ShareSocialNetworkSend {

    private final FacebookApi facebookApi;

    @Autowired
    public Facebook(FacebookApi facebookApi) {
        this.facebookApi = facebookApi;
    }

    @Override
    public Mono<ShareResponse> execute(ShareRequest request) {
        ShareDecorator<FacebookResponse, FacebookRequest> send = new ShareDecorator<>(
                new ShareRequestToFacebookRequestAdapter(),
                new FacebookResponseToShareResponse(),
                facebookApi
        );

        return send.execute(request);
    }
}
