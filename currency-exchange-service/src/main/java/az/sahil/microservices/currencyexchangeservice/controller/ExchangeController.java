package az.sahil.microservices.currencyexchangeservice.controller;

import az.sahil.microservices.currencyexchangeservice.entity.CurrencyExchange;
import az.sahil.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("currency-exchange")
public class ExchangeController {

    private final Environment environment;
    private final CurrencyExchangeRepository exchangeRepository;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange getCurrencyExchange(@PathVariable("from") String from,
                                                @PathVariable("to") String to) {
        String port = environment.getProperty("local.server.port");
        String[] envs = environment.getActiveProfiles();
        String env = envs.length > 0 ? envs[0] : "default";
        CurrencyExchange currencyExchange = exchangeRepository.findByFromAndTo(from.toUpperCase(), to.toUpperCase())
                .orElseThrow(() -> new RuntimeException(CurrencyExchange.class.getName() + " not found!"));
        currencyExchange.setEnvironment("Port: " + port + " Env: " + env);
        log.info("getCurrencyExchange called with from {} to {}", from, to);
        return currencyExchange;
    }

}
