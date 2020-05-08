package ronjones.share.socialnetwork.instagram.adapter;

import ronjones.share.core.share.ShareRequest;
import ronjones.share.core.share.interfaces.ShareRequestAdapter;
import ronjones.share.socialnetwork.instagram.InstagramRequest;

public class ShareRequestToInstagramRequestAdapter implements ShareRequestAdapter<InstagramRequest> {

    @Override
    public InstagramRequest convert(ShareRequest shareRequest) {
        InstagramRequest instagramRequest = new InstagramRequest();
        instagramRequest.setEmail(shareRequest.getEmail());
        instagramRequest.setMessage(shareRequest.getMessage());
        instagramRequest.setLinkPhoto(shareRequest.getLinkPhoto());
        return instagramRequest;
    }

}
