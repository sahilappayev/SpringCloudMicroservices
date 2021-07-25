package az.sahil.microservices.limitservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "limit-service")
public class LimitConfig {
    int minimum;
    int maximum;
}
