[![Build Status](https://travis-ci.org/theborakompanioni/tbk-spring-useragentutils.svg)](https://travis-ci.org/theborakompanioni/tbk-spring-useragentutils)

tbk-spring-useragentutils
===

A [Spring](https://spring.io/) user-agent resolver for server-side detection of browser and operating system.

### Download

#### Maven
```xml
<dependency>
    <groupId>com.github.theborakompanioni</groupId>
    <artifactId>spring-useragentutils</artifactId>
    <version>1.1.1</version>
</dependency>
```

### Usage
Create a `UserAgentResolverHandlerInterceptor` and a `UserAgentHandlerMethodArgumentResolver` bean.

#### Example Configuration
```java
@Configuration
public class SpringUserAgentUtilsConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public UserAgentResolverHandlerInterceptor userAgentResolverHandlerInterceptor() {
        return new UserAgentResolverHandlerInterceptor();
    }

    @Bean
    public UserAgentHandlerMethodArgumentResolver userAgentHandlerMethodArgumentResolver() {
        return new UserAgentHandlerMethodArgumentResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userAgentResolverHandlerInterceptor());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userAgentHandlerMethodArgumentResolver());
    }
}
```
#### Example Controller

The following example shows a controller returning a resolved UserAgent object either
from a given User-Agent string or resolved from the requesting client:

```java
@RestController
@RequestMapping("/app/rest/useragent")
public class UserAgentCtrl {

    @Builder
    @Value
    private static class UserAgentResource {
        private Browser browser;
        private BrowserType browserType;
        private OperatingSystem operatingSystem;
        private OperatingSystem operatingSystemGroup;
        private DeviceType deviceType;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UserAgentResource> userAgent(
        @RequestParam(value = "userAgent", required = false) String userAgentString,
        UserAgent clientUserAgent
    ) {
        UserAgent userAgent = Strings.isNullOrEmpty(userAgentString) ? clientUserAgent :
            UserAgent.parseUserAgentString(userAgentString);

        Browser browser = userAgent.getBrowser();
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();

        UserAgentResource resource = UserAgentResource.builder()
            .browser(browser)
            .browserType(browser.getBrowserType())
            .operatingSystem(operatingSystem)
            .operatingSystemGroup(operatingSystem.getGroup())
            .deviceType(operatingSystem.getDeviceType())
            .build();

        return ResponseEntity.ok(resource);
    }
}
```

Request URL: `http://localhost:8080/app/rest/useragent`
Returns the client user agent, e.g.:
```javascript
{
  "browser": "FIREFOX36",
  "browserType": "WEB_BROWSER",
  "operatingSystem": "LINUX",
  "operatingSystemGroup": "LINUX",
  "deviceType": "COMPUTER"
}
```


Request URL: `http://localhost:8080/app/rest/useragent?userAgent=Mozilla%2F5.0%20(compatible%3B%20MSIE%2010.0%3B%20Windows%20NT%206.1%3B%20Trident%2F4.0%3B%20InfoPath.2%3B%20SV1%3B%20.NET%20CLR%202.0.50727%3B%20WOW64)`

```javascript
{
  "browser": "IE10",
  "browserType": "WEB_BROWSER",
  "operatingSystem": "WINDOWS_7",
  "operatingSystemGroup": "WINDOWS",
  "deviceType": "COMPUTER"
}
```


License
-------

The project is licensed under the MIT license. See
[LICENSE](https://github.com/theborakompanioni/tbk-spring-useragentutils/blob/master/LICENSE) for details.
