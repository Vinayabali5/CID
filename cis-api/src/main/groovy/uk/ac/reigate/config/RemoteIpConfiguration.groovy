package uk.ac.reigate.config

import org.apache.catalina.filters.RemoteIpFilter

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RemoteIpConfiguration {
    
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }
}
