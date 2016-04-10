package com.github.theborakompanioni.spring.useragentutils;

import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;

public class SimpleUserAgentResolver implements UserAgentResolver {
    public UserAgent resolveUserAgent(HttpServletRequest request) {
        String userAgentOrNull = request.getHeader(HttpHeaders.USER_AGENT);

        return UserAgent.parseUserAgentString(userAgentOrNull);
    }
}
