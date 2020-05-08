package ronjones.share.core.share.interfaces;

import reactor.core.publisher.Mono;
import ronjones.share.core.share.ShareRequest;
import ronjones.share.core.share.ShareResponse;

public interface ShareSocialNetworkSend {

    Mono<ShareResponse> execute(ShareRequest request);
}
