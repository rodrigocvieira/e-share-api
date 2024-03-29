package ronjones.share.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ronjones.share.core.share.ShareRequest;
import ronjones.share.core.share.ShareResponse;
import ronjones.share.factory.ShareFactory;

@Service
public class PublishService {

    private final ShareFactory shareFactory;

    @Autowired
    public PublishService(ShareFactory shareFactory) {
        this.shareFactory = shareFactory;
    }

    public Flux<ShareResponse> send(ShareRequest request) {
        return Flux.fromIterable(request.getSocialNetworkLists())
                .flatMap(socialNetwork -> shareFactory.build(socialNetwork).execute(request));
    }
}
