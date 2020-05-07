package ronjones.share.socialnetwork.facebook.api;

import ronjones.share.common.share.Api;
import ronjones.share.socialnetwork.facebook.FacebookRequest;
import ronjones.share.socialnetwork.facebook.FacebookResponse;

import java.util.UUID;

public class FacebookApi implements Api<FacebookResponse, FacebookRequest> {

    @Override
    public FacebookResponse send(FacebookRequest facebookRequest) {
        FacebookResponse facebookResponse = new FacebookResponse();
        facebookResponse.setUuid(UUID.randomUUID().toString());
        return facebookResponse;
    }
}
