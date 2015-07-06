package com.github.theborakompanioni.spring.useragentutils.test.integration;

import eu.bitwalker.useragentutils.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/useragent")
class UserAgentTestCtrl {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UserAgentResource> userAgent(UserAgent userAgent) {
        Browser browser = userAgent.getBrowser();
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();

        UserAgentResource resource = UserAgentResource.builder()
            .browser(browser)
            .browserGroup(browser.getGroup())
            .browserType(browser.getBrowserType())
            .operatingSystem(operatingSystem)
            .operatingSystemGroup(operatingSystem.getGroup())
            .deviceType(operatingSystem.getDeviceType())
            .build();

        return ResponseEntity.ok(resource);
    }
}