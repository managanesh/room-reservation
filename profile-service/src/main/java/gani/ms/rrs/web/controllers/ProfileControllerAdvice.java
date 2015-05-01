package gani.ms.rrs.web.controllers;

import gani.ms.rrs.domain.Result;
import gani.ms.rrs.tracing.RequestCorrelation;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Created by ganesh.vallabhaneni on 4/29/2015.
 */
@ControllerAdvice
public class ProfileControllerAdvice implements ResponseBodyAdvice<Object> {


    /**
     * Selects which types are being adviced (wrapped)
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // here we can setup a filter for types we don't want to wrap
        return true;
    }

    /**
     * Intercepts a response before it is converted.
     */
    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        // don't wrap a body that is already wrapped (must be exception being handled)
        Result result = new Result(body);
        result.setStatus("true");
        result.setTarackingId(RequestCorrelation.getId());
        return body instanceof Result ? body : result;
    }
}
