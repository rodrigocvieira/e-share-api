package ronjones.share.core.share;

public interface Api<Response, Request> {

    Response send(Request request);
}
