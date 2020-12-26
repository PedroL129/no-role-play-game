package com.pedrol129.nrpg.game.configuration;

import com.pedrol129.nrpg.mapclient.api.MapControllerApi;
import com.pedrol129.nrpg.mapclient.invoker.ApiClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapIntegrationConfig {

    @Bean
    public MapControllerApi mapApi() {
        return new MapControllerApi(apiClient()) ;
    }

    @Bean
    public ApiClient apiClient() {
        return new ApiClient();

    }
}
