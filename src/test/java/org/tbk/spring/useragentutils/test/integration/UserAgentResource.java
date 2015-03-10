package org.tbk.spring.useragentutils.test.integration;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.BrowserType;
import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.OperatingSystem;

class UserAgentResource {
    private Browser browser;
    private Browser browserGroup;
    private BrowserType browserType;
    private OperatingSystem operatingSystem;
    private OperatingSystem operatingSystemGroup;
    private DeviceType deviceType;

    public UserAgentResource(Browser browser, Browser browserGroup, BrowserType browserType, OperatingSystem operatingSystem, OperatingSystem operatingSystemGroup, DeviceType deviceType) {
        this.browser = browser;
        this.browserGroup = browserGroup;
        this.browserType = browserType;
        this.operatingSystem = operatingSystem;
        this.operatingSystemGroup = operatingSystemGroup;
        this.deviceType = deviceType;
    }

    public static UserAgentResourceBuilder builder() {
        return new UserAgentResourceBuilder();
    }

    public Browser getBrowser() {
        return this.browser;
    }

    public Browser getBrowserGroup() {
        return this.browserGroup;
    }

    public BrowserType getBrowserType() {
        return this.browserType;
    }

    public OperatingSystem getOperatingSystem() {
        return this.operatingSystem;
    }

    public OperatingSystem getOperatingSystemGroup() {
        return this.operatingSystemGroup;
    }

    public DeviceType getDeviceType() {
        return this.deviceType;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof UserAgentResource)) return false;
        final UserAgentResource other = (UserAgentResource) o;
        final Object this$browser = this.browser;
        final Object other$browser = other.browser;
        if (this$browser == null ? other$browser != null : !this$browser.equals(other$browser)) return false;
        final Object this$browserGroup = this.browserGroup;
        final Object other$browserGroup = other.browserGroup;
        if (this$browserGroup == null ? other$browserGroup != null : !this$browserGroup.equals(other$browserGroup))
            return false;
        final Object this$browserType = this.browserType;
        final Object other$browserType = other.browserType;
        if (this$browserType == null ? other$browserType != null : !this$browserType.equals(other$browserType))
            return false;
        final Object this$operatingSystem = this.operatingSystem;
        final Object other$operatingSystem = other.operatingSystem;
        if (this$operatingSystem == null ? other$operatingSystem != null : !this$operatingSystem.equals(other$operatingSystem))
            return false;
        final Object this$operatingSystemGroup = this.operatingSystemGroup;
        final Object other$operatingSystemGroup = other.operatingSystemGroup;
        if (this$operatingSystemGroup == null ? other$operatingSystemGroup != null : !this$operatingSystemGroup.equals(other$operatingSystemGroup))
            return false;
        final Object this$deviceType = this.deviceType;
        final Object other$deviceType = other.deviceType;
        if (this$deviceType == null ? other$deviceType != null : !this$deviceType.equals(other$deviceType))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $browser = this.browser;
        result = result * PRIME + ($browser == null ? 0 : $browser.hashCode());
        final Object $browserGroup = this.browserGroup;
        result = result * PRIME + ($browserGroup == null ? 0 : $browserGroup.hashCode());
        final Object $browserType = this.browserType;
        result = result * PRIME + ($browserType == null ? 0 : $browserType.hashCode());
        final Object $operatingSystem = this.operatingSystem;
        result = result * PRIME + ($operatingSystem == null ? 0 : $operatingSystem.hashCode());
        final Object $operatingSystemGroup = this.operatingSystemGroup;
        result = result * PRIME + ($operatingSystemGroup == null ? 0 : $operatingSystemGroup.hashCode());
        final Object $deviceType = this.deviceType;
        result = result * PRIME + ($deviceType == null ? 0 : $deviceType.hashCode());
        return result;
    }

    public String toString() {
        return "org.tbk.spring.useragentutils.test.integration.UserAgentTestCtrl.UserAgentResource(browser=" + this.browser + ", browserGroup=" + this.browserGroup + ", browserType=" + this.browserType + ", operatingSystem=" + this.operatingSystem + ", operatingSystemGroup=" + this.operatingSystemGroup + ", deviceType=" + this.deviceType + ")";
    }

    public static class UserAgentResourceBuilder {
        private Browser browser;
        private Browser browserGroup;
        private BrowserType browserType;
        private OperatingSystem operatingSystem;
        private OperatingSystem operatingSystemGroup;
        private DeviceType deviceType;

        UserAgentResourceBuilder() {
        }

        public UserAgentResource.UserAgentResourceBuilder browser(Browser browser) {
            this.browser = browser;
            return this;
        }

        public UserAgentResource.UserAgentResourceBuilder browserGroup(Browser browserGroup) {
            this.browserGroup = browserGroup;
            return this;
        }

        public UserAgentResource.UserAgentResourceBuilder browserType(BrowserType browserType) {
            this.browserType = browserType;
            return this;
        }

        public UserAgentResource.UserAgentResourceBuilder operatingSystem(OperatingSystem operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        public UserAgentResource.UserAgentResourceBuilder operatingSystemGroup(OperatingSystem operatingSystemGroup) {
            this.operatingSystemGroup = operatingSystemGroup;
            return this;
        }

        public UserAgentResource.UserAgentResourceBuilder deviceType(DeviceType deviceType) {
            this.deviceType = deviceType;
            return this;
        }

        public UserAgentResource build() {
            return new UserAgentResource(browser, browserGroup, browserType, operatingSystem, operatingSystemGroup, deviceType);
        }

        public String toString() {
            return "org.tbk.spring.useragentutils.test.integration.UserAgentTestCtrl.UserAgentResource.UserAgentResourceBuilder(browser=" + this.browser + ", browserGroup=" + this.browserGroup + ", browserType=" + this.browserType + ", operatingSystem=" + this.operatingSystem + ", operatingSystemGroup=" + this.operatingSystemGroup + ", deviceType=" + this.deviceType + ")";
        }
    }
}