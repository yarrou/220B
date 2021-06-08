package by.v.services;

import by.v.entity.Currency;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class ProviderFromNBRB {
    @SneakyThrows
    public Currency getNowCurrency() {
        final URL url = new URL("https://www.nbrb.by/api/exrates/rates/usd?parammode=2");
        ObjectMapper objectMapper = new ObjectMapper();
        Currency currency = objectMapper.readValue(url,Currency.class);
        return currency;
    }
}
