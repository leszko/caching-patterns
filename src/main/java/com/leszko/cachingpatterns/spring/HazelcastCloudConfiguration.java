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
            .setDiscoveryToken("EMMUWuADyJuh0d8GiLbdymveoFsjdGUypQKrpVLxBqGRsPblwo");
        clientConfig.setGroupConfig(new GroupConfig(
            "rafal-cluster",
            "abff7ad094114e3c9992f3584c111271")
        );

        return new HazelcastCacheManager(HazelcastClient.newHazelcastClient(clientConfig));
    }
}
