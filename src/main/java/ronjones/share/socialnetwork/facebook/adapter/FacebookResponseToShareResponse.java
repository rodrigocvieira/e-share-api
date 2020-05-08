package ronjones.share.socialnetwork.facebook.adapter;

import ronjones.share.core.share.ShareResponse;
import ronjones.share.core.share.interfaces.ShareResponseAdapter;
import ronjones.share.socialnetwork.facebook.FacebookResponse;

public class FacebookResponseToShareResponse implements ShareResponseAdapter<FacebookResponse> {

    @Override
    public ShareResponse convert(FacebookResponse request) {
        ShareResponse response = new ShareResponse();
        response.setUuid(request.getUuid());
        return response;
    }
}
