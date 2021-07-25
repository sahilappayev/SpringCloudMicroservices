package az.sahil.microservices.apigateway.configuration;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(p -> p.path("/sahilappayev")
                        .filters(f -> f
                                .addRequestHeader("Header", "HeaderValue"))
                        .uri("https://www.facebook.com"))
                .route(p -> p.path("/currency-conversion/**")
                        .uri("lb://currency-conversion-service"))
                .route(p -> p.path("/currency-conversion-new/**")
                        .filters(f -> f.rewritePath("/currency-conversion-new/(?<segment>.*)",
                                "/currency-conversion/${segment}"))
                        .uri("lb://currency-conversion-service"))
                .route(p -> p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange-service"))
                .build();
    }

}
