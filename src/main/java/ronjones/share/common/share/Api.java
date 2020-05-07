package ronjones.share.common.share;

public interface Api<Response, Request> {

    Response send(Request request);
}
