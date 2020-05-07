package ronjones.share.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ronjones.share.common.share.ShareRequest;
import ronjones.share.common.share.ShareResponse;
import ronjones.share.common.share.enuns.SocialNetwork;
import ronjones.share.factory.ShareFactory;

@Service
public class PublishService {
    public Flux<ShareResponse> send(ShareRequest request) {
        return Flux.fromIterable(request.getSocialNetworkLists())
                .flatMap(socialNetwork -> ShareFactory.build(SocialNetwork.FACEBOOK).run(request));
    }
}
