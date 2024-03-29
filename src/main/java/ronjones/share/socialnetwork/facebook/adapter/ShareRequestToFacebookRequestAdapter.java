package ronjones.share.socialnetwork.facebook.adapter;

import ronjones.share.core.share.ShareRequest;
import ronjones.share.core.share.interfaces.ShareRequestAdapter;
import ronjones.share.socialnetwork.facebook.FacebookRequest;

public class ShareRequestToFacebookRequestAdapter implements ShareRequestAdapter<FacebookRequest> {

    @Override
    public FacebookRequest convert(ShareRequest shareRequest) {
        FacebookRequest facebookRequest = new FacebookRequest();
        facebookRequest.setEmail(shareRequest.getEmail());
        facebookRequest.setMessage(shareRequest.getMessage());
        facebookRequest.setLinkPhoto(shareRequest.getLinkPhoto());
        return facebookRequest;
    }

}
