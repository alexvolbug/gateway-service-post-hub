package com.post_hub.gateway.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.providers.SpringDocProviders;
import org.springdoc.core.service.AbstractRequestService;
import org.springdoc.core.service.GenericResponseService;
import org.springdoc.core.service.OpenAPIService;
import org.springdoc.core.service.OperationService;
import org.springdoc.webflux.api.MultipleOpenApiWebFluxResource;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.customizers.SpringDocCustomizers;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("'POST_HUB' REST API endpoints")
                        .description("""
                                'Gateway-service' - is the starting point for the rest of the microservices and the main URL for all endpoints.

                                Created by Aleksey Volchenko | <a href='mailto:alexvolbug@gmail.com'>Send me email</a>"""
                        )
                        .version("1.0")
                );
    }

    @Bean
    public MultipleOpenApiWebFluxResource multipleOpenApiResource(
            List<GroupedOpenApi> groupedOpenApis,
            ObjectFactory<OpenAPIService> defaultOpenAPIBuilder,
            AbstractRequestService requestBuilder,
            GenericResponseService responseBuilder,
            OperationService operationParser,
            SpringDocConfigProperties springDocConfigProperties,
            SpringDocProviders springDocProviders,
            SpringDocCustomizers springDocCustomizers
    ) {
        return new MultipleOpenApiWebFluxResource(
                groupedOpenApis,
                defaultOpenAPIBuilder,
                requestBuilder,
                responseBuilder,
                operationParser,
                springDocConfigProperties,
                springDocProviders,
                springDocCustomizers
        );
    }
}
