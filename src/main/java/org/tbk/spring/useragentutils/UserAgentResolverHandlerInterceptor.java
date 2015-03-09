package org.tbk.spring.useragentutils;

import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAgentResolverHandlerInterceptor extends HandlerInterceptorAdapter {
    private final UserAgentResolver userAgentResolver;

    public UserAgentResolverHandlerInterceptor() {
        this(new SimpleUserAgentResolver());
    }

    public UserAgentResolverHandlerInterceptor(UserAgentResolver browserResolver) {
        this.userAgentResolver = browserResolver;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserAgent userAgent = this.userAgentResolver.resolveUserAgent(request);
        request.setAttribute(UserAgentUtils.CURRENT_USERAGENT_ATTRIBUTE, userAgent);

        return true;
    }
}
