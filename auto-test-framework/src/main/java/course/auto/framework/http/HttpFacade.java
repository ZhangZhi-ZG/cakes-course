package course.auto.framework.http;

import course.auto.framework.http.chain.HttpHandlerChainManager;
import course.auto.framework.http.service.HttpService;
import course.auto.framework.model.HttpRequest;
import course.auto.framework.model.HttpResponse;

import java.util.Map;

public final class HttpFacade {

    private HttpFacade() {

    }

    public static String doPostForm(String url, Map<String, String> headers, Map<String, Object> params) {
        return null;
    }

    public static String doPostJson(String url, Object data) {
        return doPostJson(url, null, data);
    }

    public static String doPostJson(String url, Map<String, String> headers, Object data) {
        return new HttpService().doPostJson(url, headers, data);
    }

    public static HttpResponse doRequest(HttpRequest request) {
        return HttpHandlerChainManager.of().doRequest(request);
    }

    public static void main(String[] args) {
        HttpFacade.doRequest(HttpRequest.builder()
                .url("")
                .doPostJson()
                .data(null)
                .build());
    }

}
