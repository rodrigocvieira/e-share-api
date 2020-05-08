package ronjones.share.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ronjones.share.core.share.ShareRequest;
import ronjones.share.core.share.ShareResponse;
import ronjones.share.core.service.PublishService;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class Endpoint {

    private final PublishService publishService;

    @Autowired
    public Endpoint(PublishService publishService) {
        this.publishService = publishService;
    }

    @PostMapping("/publish")
    public Flux<ShareResponse> publish(@Valid @RequestBody ShareRequest request) {
        return publishService.send(request)
                .doOnError(throwable -> System.out.println("Erro"));
    }
}
