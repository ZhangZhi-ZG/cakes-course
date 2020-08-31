package course.auto.framework.http.chain;

import course.auto.framework.model.HttpRequest;
import course.auto.framework.model.HttpResponse;

public final class HttpHandlerChainManager {

    private final AbstractHttpHandler httpHandler;

    private HttpHandlerChainManager() {
        this.httpHandler = initHandlerChain();
    }

    private AbstractHttpHandler initHandlerChain() {
        AbstractHttpHandler postFormHandler = new PostFormHttpHandler();
        AbstractHttpHandler postJsonHandler = new PostJsonHttpHandler();
        postFormHandler.setNextHandler(postJsonHandler);
        return postFormHandler;
    }

    private static final class ClassHolder {
        private static final HttpHandlerChainManager INSTANCE = new HttpHandlerChainManager();
    }

    public static HttpHandlerChainManager of() {
        return ClassHolder.INSTANCE;
    }

    public HttpResponse doRequest(HttpRequest request) {
        return this.httpHandler.doRequest(request);
    }

}
