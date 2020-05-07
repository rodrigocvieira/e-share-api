package ronjones.share.common.share;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import ronjones.share.common.share.enuns.SocialNetwork;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class ShareRequest {

    private String email;
    private String message;
    private String linkPhoto;
    private List<SocialNetwork> socialNetworkLists;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLinkPhoto() {
        return linkPhoto;
    }

    public void setLinkPhoto(String linkPhoto) {
        this.linkPhoto = linkPhoto;
    }

    public List<SocialNetwork> getSocialNetworkLists() {
        return socialNetworkLists;
    }

    public void setSocialNetworkLists(List<SocialNetwork> socialNetworkLists) {
        this.socialNetworkLists = socialNetworkLists;
    }
}
