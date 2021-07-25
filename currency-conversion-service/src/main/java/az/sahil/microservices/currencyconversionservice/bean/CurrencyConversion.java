package az.sahil.microservices.currencyconversionservice.bean;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CurrencyConversion {
    Long id;
    String from;
    String to;
    BigDecimal conversionMultiple;
    BigDecimal quantity;
    BigDecimal totalCalculatedAmount;
    String environment;
}
