package ronjones.share.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ronjones.share.common.share.ShareRequest;
import ronjones.share.common.share.ShareResponse;
import ronjones.share.service.PublishService;

@RestController
@RequestMapping("/v1")
public class Endpoint {

    private final PublishService publishService;

    @Autowired
    public Endpoint(PublishService publishService) {
        this.publishService = publishService;
    }

    @PostMapping("/publish")
    public Mono<ShareResponse> publish(@RequestBody ShareRequest request,
                                       Mono<Object> test) {
        return test.flatMap(o -> {
            return publishService.send(request)
                    .doOnSuccess(shareResponse -> System.out.println("Success"))
                    .doOnError(throwable -> System.out.println("Erro"));
        });
    }
}
