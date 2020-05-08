package ronjones.share.core.decorator;

import reactor.core.publisher.Mono;
import ronjones.share.core.share.ShareRequest;
import ronjones.share.core.share.ShareResponse;
import ronjones.share.core.share.interfaces.Api;
import ronjones.share.core.share.interfaces.ShareRequestAdapter;
import ronjones.share.core.share.interfaces.ShareResponseAdapter;

public class ShareDecorator<Response, Request> {

    private final ShareRequestAdapter<Request> shareRequestAdapter;
    private final ShareResponseAdapter<Response> shareResponseAdapter;
    private final Api<Response, Request> api;

    public ShareDecorator(ShareRequestAdapter<Request> shareRequestAdapter,
                          ShareResponseAdapter<Response> shareResponseAdapter,
                          Api<Response, Request> api) {
        this.shareRequestAdapter = shareRequestAdapter;
        this.shareResponseAdapter = shareResponseAdapter;
        this.api = api;
    }

    public Mono<ShareResponse> execute(ShareRequest request) {
        return Mono.just(
                shareResponseAdapter
                        .convert(api
                                .send(shareRequestAdapter
                                        .convert(request))));
    }
}
