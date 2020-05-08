package ronjones.share.core.share.interfaces;

public interface Api<Response, Request> {

    Response send(Request request);
}
