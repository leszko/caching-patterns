package com.leszko.cachingpatterns.spring;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.spi.impl.discovery.HazelcastCloudDiscovery;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastCloudConfiguration {
    @Bean
    CacheManager cacheManager() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().getCloudConfig()
            .setEnabled(true)
            .setDiscoveryToken("KSXFDTc8OX3zxXryD3Zi5HXPJGR0wRAjLgKe45uMce3NtvEEhd");
        clientConfig.setGroupConfig(new GroupConfig(
            "cluster-name",
            "b2f929dafdb84ca7b254fc84b5dd3314")
        );

        return new HazelcastCacheManager(HazelcastClient.newHazelcastClient(clientConfig));
    }
}
