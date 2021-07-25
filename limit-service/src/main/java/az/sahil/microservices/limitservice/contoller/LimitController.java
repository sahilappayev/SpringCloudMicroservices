package az.sahil.microservices.limitservice.contoller;

import az.sahil.microservices.limitservice.bean.Limit;
import az.sahil.microservices.limitservice.configuration.LimitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("limits")
public class LimitController {

    private final LimitConfig limitConfig;

    @GetMapping
    public Limit getLimits() {
        return new Limit(limitConfig.getMinimum(),limitConfig.getMaximum());
    }
}
