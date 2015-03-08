package org.tbk.spring.useragentutils;

import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by void on 08.03.15.
 */
public interface UserAgentResolver {
    UserAgent resolveUserAgent(HttpServletRequest request);
}
