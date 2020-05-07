package ronjones.share.decorator;

import reactor.core.publisher.Mono;
import ronjones.share.common.share.Api;
import ronjones.share.common.share.ShareRequest;
import ronjones.share.common.share.ShareResponse;
import ronjones.share.common.share.interfaces.ShareRequestAdapter;
import ronjones.share.common.share.interfaces.ShareResponseAdapter;

public class ShareDecorator<Response, Request> {

    private final ShareRequestAdapter<Request> shareRequestAdapter;
    private final ShareResponseAdapter<Response> shareResponseAdapter;
    private final Api<Response, Request> api;

    public ShareDecorator(ShareRequestAdapter shareRequestAdapter,
                          ShareResponseAdapter shareResponseAdapter,
                          Api<Response, Request> api) {
        this.shareRequestAdapter = shareRequestAdapter;
        this.shareResponseAdapter = shareResponseAdapter;
        this.api = api;
    }

    public Mono<ShareResponse> run(ShareRequest request) {
        return Mono.just(
                shareResponseAdapter
                        .convert(api
                                .send(shareRequestAdapter
                                        .convert(request))));
    }
}
