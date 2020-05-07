package ronjones.share.socialnetwork.instagram.api;

import ronjones.share.common.share.Api;
import ronjones.share.socialnetwork.instagram.InstagramRequest;
import ronjones.share.socialnetwork.instagram.InstagramResponse;

import java.util.UUID;

public class InstagramApi implements Api<InstagramResponse, InstagramRequest> {

    @Override
    public InstagramResponse send(InstagramRequest instagramRequest) {
        InstagramResponse instagramResponse = new InstagramResponse();
        instagramResponse.setUuid(UUID.randomUUID().toString());
        return instagramResponse;
    }
}
