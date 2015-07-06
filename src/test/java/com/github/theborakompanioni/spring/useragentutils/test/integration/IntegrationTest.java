package com.github.theborakompanioni.spring.useragentutils.test.integration;

import com.github.theborakompanioni.spring.useragentutils.test.UserAgentStrings;
import eu.bitwalker.useragentutils.Browser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringUserAgentUtilsTestConfiguration.class})
@WebAppConfiguration
public class IntegrationTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testWithoutUserAgent() throws Exception {
        mockMvc.perform(get("/test/useragent").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("browser").value(Browser.UNKNOWN.name()));
    }

    @Test
    public void testWithEmptyUserAgent() throws Exception {
        mockMvc.perform(get("/test/useragent")
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.USER_AGENT, ""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("browser").value(Browser.UNKNOWN.name()));
    }

    @Test
    public void testFirefoxUserAgent() throws Exception {
        mockMvc.perform(get("/test/useragent")
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.USER_AGENT, UserAgentStrings.FIREFOX))
                .andExpect(status().isOk())
                .andExpect(jsonPath("browserGroup").value(Browser.FIREFOX.getGroup().name()));
    }

}
