package ronjones.share.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ronjones.share.core.decorator.ShareDecorator;
import ronjones.share.core.share.enuns.SocialNetwork;
import ronjones.share.core.share.exceptions.SocialNetworkException;
import ronjones.share.socialnetwork.facebook.adapter.FacebookResponseToShareResponse;
import ronjones.share.socialnetwork.facebook.adapter.ShareRequestToFacebookRequestAdapter;
import ronjones.share.socialnetwork.facebook.api.FacebookApi;
import ronjones.share.socialnetwork.instagram.adapter.InstagramResponseToShareResponse;
import ronjones.share.socialnetwork.instagram.adapter.ShareRequestToInstagramRequestAdapter;
import ronjones.share.socialnetwork.instagram.api.InstagramApi;

@Component
public class ShareFactory {

    private final FacebookApi facebookApi;
    private final InstagramApi instagramApi;

    @Autowired
    public ShareFactory(FacebookApi facebookApi,
                        InstagramApi instagramApi) {
        this.facebookApi = facebookApi;
        this.instagramApi = instagramApi;
    }

    public ShareDecorator<?, ?> build(SocialNetwork socialNetwork) {

        switch (socialNetwork) {
            case FACEBOOK:
                return new ShareDecorator<>(
                        new ShareRequestToFacebookRequestAdapter(),
                        new FacebookResponseToShareResponse(),
                        facebookApi
                );
            case INSTAGRAM:
                return new ShareDecorator<>(
                        new ShareRequestToInstagramRequestAdapter(),
                        new InstagramResponseToShareResponse(),
                        instagramApi
                );
            default:
                throw new SocialNetworkException(String.format("%s não implementado", socialNetwork));
        }

    }
}
