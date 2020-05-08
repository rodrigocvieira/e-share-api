package ronjones.share.core.share;

import com.fasterxml.jackson.annotation.JsonInclude;
import ronjones.share.core.share.enuns.SocialNetwork;

import javax.validation.constraints.NotNull;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class ShareRequest {

    @NotNull(message = "Email não informado!")
    private String email;

    private String message;

    private String linkPhoto;

    @NotNull(message = "Nenhuma rede social informada!")
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
