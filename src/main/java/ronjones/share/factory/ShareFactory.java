package ronjones.share.factory;

import ronjones.share.common.share.enuns.SocialNetwork;
import ronjones.share.common.share.exceptions.SocialNetworkException;
import ronjones.share.decorator.ShareDecorator;
import ronjones.share.socialnetwork.facebook.adapter.FacebookResponseToShareResponse;
import ronjones.share.socialnetwork.facebook.adapter.ShareRequestToFacebookRequestAdapter;
import ronjones.share.socialnetwork.facebook.api.FacebookApi;
import ronjones.share.socialnetwork.instagram.adapter.InstagramResponseToShareResponse;
import ronjones.share.socialnetwork.instagram.adapter.ShareRequestToInstagramRequestAdapter;
import ronjones.share.socialnetwork.instagram.api.InstagramApi;

public class ShareFactory {

    public static ShareDecorator<?, ?> build(SocialNetwork socialNetwork) {

        switch (socialNetwork){
            case FACEBOOK:
                return new ShareDecorator<>(
                        new ShareRequestToFacebookRequestAdapter(),
                        new FacebookResponseToShareResponse(),
                        new FacebookApi()
                );
            case INSTAGRAM:
                return new ShareDecorator<>(
                        new ShareRequestToInstagramRequestAdapter(),
                        new InstagramResponseToShareResponse(),
                        new InstagramApi()
                );
            default:
                throw new SocialNetworkException(String.format("%s não implementado", socialNetwork));
        }

    }
}
