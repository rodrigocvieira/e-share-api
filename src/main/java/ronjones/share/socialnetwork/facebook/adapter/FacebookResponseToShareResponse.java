package ronjones.share.socialnetwork.facebook.adapter;

import ronjones.share.common.share.ShareResponse;
import ronjones.share.common.share.interfaces.ShareResponseAdapter;
import ronjones.share.socialnetwork.facebook.FacebookResponse;

public class FacebookResponseToShareResponse implements ShareResponseAdapter<FacebookResponse> {

    @Override
    public ShareResponse convert(FacebookResponse request) {
        ShareResponse response = new ShareResponse();
        response.setUuid(request.getUuid());
        return response;
    }
}
