package ronjones.share.socialnetwork.instagram.adapter;

import ronjones.share.common.share.ShareResponse;
import ronjones.share.common.share.interfaces.ShareResponseAdapter;
import ronjones.share.socialnetwork.instagram.InstagramResponse;

public class InstagramResponseToShareResponse implements ShareResponseAdapter<InstagramResponse> {

    @Override
    public ShareResponse convert(InstagramResponse request) {
        ShareResponse response = new ShareResponse();
        response.setUuid(request.getUuid());
        return response;
    }
}
