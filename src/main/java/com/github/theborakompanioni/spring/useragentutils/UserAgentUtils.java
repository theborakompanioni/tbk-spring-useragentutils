package com.github.theborakompanioni.spring.useragentutils;

import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.web.context.request.RequestAttributes;

import javax.servlet.http.HttpServletRequest;

public final class UserAgentUtils {
    static final String CURRENT_USERAGENT_ATTRIBUTE = "currentUserAgent";

    private UserAgentUtils() {
        throw new UnsupportedOperationException();
    }

    public static UserAgent getCurrentUserAgent(HttpServletRequest request) {
        return (UserAgent) request.getAttribute(CURRENT_USERAGENT_ATTRIBUTE);
    }

    public static UserAgent getCurrentUserAgent(RequestAttributes attributes) {
        return (UserAgent) attributes.getAttribute(CURRENT_USERAGENT_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
    }
}
