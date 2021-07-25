package az.sahil.microservices.currencyconversionservice.controller;

import az.sahil.microservices.currencyconversionservice.bean.CurrencyConversion;
import az.sahil.microservices.currencyconversionservice.client.CurrencyExchangeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/currency-conversion")
public class ConversionController {

    private final CurrencyExchangeClient exchangeClient;

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getCurrencyConversion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable int quantity
    ) {
        CurrencyConversion currencyConversion = exchangeClient.getCurrencyExchange(from, to);
        currencyConversion.setQuantity(BigDecimal.valueOf(quantity));
        currencyConversion.setTotalCalculatedAmount(
                currencyConversion.getQuantity().multiply(currencyConversion.getConversionMultiple()));
        return currencyConversion;
    }

}
