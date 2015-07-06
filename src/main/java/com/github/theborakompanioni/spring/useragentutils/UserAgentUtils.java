package com.github.theborakompanioni.spring.useragentutils;

import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.web.context.request.RequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class UserAgentUtils {
    public static final String CURRENT_USERAGENT_ATTRIBUTE = "currentUserAgent";

    public UserAgentUtils() {
    }

    public static UserAgent getCurrentUserAgent(HttpServletRequest request) {
        return (UserAgent)request.getAttribute(CURRENT_USERAGENT_ATTRIBUTE);
    }

    public static UserAgent getCurrentUserAgent(RequestAttributes attributes) {
        return (UserAgent)attributes.getAttribute(CURRENT_USERAGENT_ATTRIBUTE, 0);
    }
}
