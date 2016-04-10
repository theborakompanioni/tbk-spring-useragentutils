package com.github.theborakompanioni.spring.useragentutils.test;

import com.github.theborakompanioni.spring.useragentutils.UserAgentResolverHandlerInterceptor;
import com.github.theborakompanioni.spring.useragentutils.UserAgentUtils;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class UserAgentResolverHandlerInterceptorTest {

    private UserAgentResolverHandlerInterceptor userAgentResolverHandlerInterceptor;

    @Before
    public void before() {
        userAgentResolverHandlerInterceptor = new UserAgentResolverHandlerInterceptor();
    }

    @Test
    public void testWithoutUserAgentHeader() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();

        userAgentResolverHandlerInterceptor.preHandle(request, new MockHttpServletResponse(), null);

        UserAgent currentUserAgent = UserAgentUtils.getCurrentUserAgent(request);
        Assert.assertEquals(Browser.UNKNOWN, currentUserAgent.getBrowser());
    }

    @Test
    public void testWithEmptyUserAgent() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader(HttpHeaders.USER_AGENT, "");

        userAgentResolverHandlerInterceptor.preHandle(request, new MockHttpServletResponse(), null);

        UserAgent currentUserAgent = UserAgentUtils.getCurrentUserAgent(request);
        Assert.assertEquals(Browser.UNKNOWN, currentUserAgent.getBrowser());
    }

    @Test
    public void testFirefoxUserAgent() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader(HttpHeaders.USER_AGENT, UserAgentStrings.FIREFOX);

        userAgentResolverHandlerInterceptor.preHandle(request, new MockHttpServletResponse(), null);

        UserAgent currentUserAgent = UserAgentUtils.getCurrentUserAgent(request);
        Assert.assertEquals(Browser.FIREFOX.getGroup(), currentUserAgent.getBrowser().getGroup());
    }
}
