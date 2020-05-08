package ronjones.share.socialnetwork.facebook.api;

import org.springframework.stereotype.Service;
import ronjones.share.core.share.interfaces.Api;
import ronjones.share.socialnetwork.facebook.FacebookRequest;
import ronjones.share.socialnetwork.facebook.FacebookResponse;

import java.util.UUID;

@Service
public class FacebookApi implements Api<FacebookResponse, FacebookRequest> {

    @Override
    public FacebookResponse send(FacebookRequest facebookRequest) {
        FacebookResponse facebookResponse = new FacebookResponse();
        facebookResponse.setUuid(UUID.randomUUID().toString());
        return facebookResponse;
    }
}
