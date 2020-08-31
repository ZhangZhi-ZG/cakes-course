package course.auto.framework.http.chain;

import course.auto.framework.model.HttpRequest;
import okhttp3.Request;

public class PostXmlHttpHandler extends AbstractHttpHandler {

    @Override
    protected boolean preRequest(HttpRequest request) {
        return false;
    }

    @Override
    protected Request createRequest(HttpRequest request) {
        return null;
    }
}
