package az.sahil.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/sample-api")
public class CircuitBreakerController {

    @GetMapping
//    @Retry(name = "sample-api", fallbackMethod = "fallback") // if occurred some error retry 3 times in "default"
    @CircuitBreaker(name = "default", fallbackMethod = "fallback")
    public String getSampleApi() {
        log.info("getSampleApi called!");
        ResponseEntity<String> forEntity = new RestTemplate().
                getForEntity("http://localhost:8080/dummy-url", String.class);
        return forEntity.getBody();
    }

    public String fallback(Exception e) {
        return "Error occurred: \n\n\n" + e.getMessage();
    }
}
