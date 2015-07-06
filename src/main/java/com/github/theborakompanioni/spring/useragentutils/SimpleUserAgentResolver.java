package com.github.theborakompanioni.spring.useragentutils;

import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;

public class SimpleUserAgentResolver implements UserAgentResolver {
    private static final String USER_AGENT_HTTP_HEADER = "User-Agent";

    public UserAgent resolveUserAgent(HttpServletRequest request) {
        String userAgent = request.getHeader(USER_AGENT_HTTP_HEADER);

        return UserAgent.parseUserAgentString(userAgent);
    }
}
