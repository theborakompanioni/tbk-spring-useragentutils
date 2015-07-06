package com.github.theborakompanioni.spring.useragentutils;

import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;

public interface UserAgentResolver {
    UserAgent resolveUserAgent(HttpServletRequest request);
}
