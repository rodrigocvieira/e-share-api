package ronjones.share.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ronjones.share.core.share.enuns.SocialNetwork;
import ronjones.share.core.share.exceptions.SocialNetworkException;
import ronjones.share.core.share.interfaces.ShareSocialNetworkSend;
import ronjones.share.socialnetwork.facebook.Facebook;
import ronjones.share.socialnetwork.instagram.Instagram;

@Component
public class ShareFactory {

    private final Facebook facebook;
    private final Instagram instagram;

    @Autowired
    public ShareFactory(Facebook facebook, Instagram instagram) {
        this.facebook = facebook;
        this.instagram = instagram;
    }

    public ShareSocialNetworkSend build(SocialNetwork socialNetwork) {
        switch (socialNetwork) {
            case FACEBOOK:
                return facebook;
            case INSTAGRAM:
                return instagram;
            default:
                throw new SocialNetworkException(String.format("%s não implementado", socialNetwork));
        }

    }
}
