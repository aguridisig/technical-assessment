package com.assement.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class SwaggerConfig
{
    @Bean
    public GroupedOpenApi publicApi()
    {
        return GroupedOpenApi.builder().group( "PricesDTO" ).pathsToMatch( "/api/v1/**" ).build();
    }

    @Bean
    public OpenAPI openApiInfo()
    {
        return new OpenAPI()
                .info( new Info().title( "Technical assessment service" )
                        .description(
                                "An item can have different prices depending on the branch where it is sold and the "
                                        + "date and time of the purchase. This API returns the price of an item for a"
                                        + " given branch and date and time." )
                        .version( "v0.0.1" )
                        .license( new License() ) );
    }
}
