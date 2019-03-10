package ltd.idcu.http;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class Req {

    public static RequestBuilder build(String uri, MultiValueMap<String, String> params, HttpMethod httpMethod, String accept){
        return MockMvcRequestBuilders
                .request(httpMethod, uri)
                .params(params)
                .accept(accept);
    }

    public static RequestBuilder build(String uri, MultiValueMap<String, String> params, HttpMethod httpMethod){
        return build(uri, params, httpMethod, MediaType.TEXT_HTML_VALUE);
    }

    public static RequestBuilder build(String uri, MultiValueMap<String, String> params){
        return build(uri, params, HttpMethod.GET, MediaType.TEXT_HTML_VALUE);
    }

    public static RequestBuilder build(String uri, HttpMethod httpMethod){
        return build(uri, new LinkedMultiValueMap<String, String>(), httpMethod);
    }

    public static RequestBuilder build(String uri) {
        return build(uri, new LinkedMultiValueMap<String, String>());
    }
}
