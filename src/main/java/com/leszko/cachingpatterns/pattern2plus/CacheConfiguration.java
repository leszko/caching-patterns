package com.leszko.cachingpatterns.pattern2plus;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {
    @Bean
    CacheManager cacheManager() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().getCloudConfig()
            .setEnabled(true)
            .setDiscoveryToken("KSXFDTi5HXPJGR0wRAjLgKe45tvEEhd");
        clientConfig.setGroupConfig(new GroupConfig("test-cluster", "b2f984b5dd3314"));

        return new HazelcastCacheManager(
            HazelcastClient.newHazelcastClient(clientConfig));
    }
}
