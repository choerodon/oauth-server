package io.choerodon.oauth.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * @author scp
 * @date 2020/9/17
 * @description 替换TokenStore 为c7n自定义的 C7nCustomRedisTokenStore
 */
@Configuration
public class C7nSecurityConfig {
    @Autowired
    private CookieConfiguration cookieConfiguration;

    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        cookieSerializer.setSameSite(cookieConfiguration.getSameSite());
        cookieSerializer.setUseSecureCookie(cookieConfiguration.isSecure());
        return cookieSerializer;
    }

}
