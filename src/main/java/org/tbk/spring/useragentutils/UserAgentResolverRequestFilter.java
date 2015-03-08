package org.tbk.spring.useragentutils;

import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAgentResolverRequestFilter extends OncePerRequestFilter {
    private final UserAgentResolver userAgentResolver;

    public UserAgentResolverRequestFilter() {
        this(new SimpleUserAgentResolver());
    }

    public UserAgentResolverRequestFilter(UserAgentResolver userAgentResolver) {
        this.userAgentResolver = userAgentResolver;
    }

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        UserAgent userAgent = this.userAgentResolver.resolveUserAgent(request);
        request.setAttribute(UserAgentUtils.CURRENT_USERAGENT_ATTRIBUTE, userAgent);
        filterChain.doFilter(request, response);
    }
}
