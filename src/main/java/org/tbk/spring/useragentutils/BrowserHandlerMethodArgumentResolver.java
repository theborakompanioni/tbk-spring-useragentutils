package org.tbk.spring.useragentutils;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class BrowserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    public boolean supportsParameter(MethodParameter parameter) {
        return Browser.class.isAssignableFrom(parameter.getParameterType());
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest request, WebDataBinderFactory binderFactory) throws Exception {
        UserAgent currentUserAgent = UserAgentUtils.getCurrentUserAgent(request);
        if (currentUserAgent == null) {
            return Browser.UNKNOWN;
        }
        return currentUserAgent.getBrowser();
    }
}
