package by.v.services;

import by.v.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class CashCurrency {
    private static volatile CashCurrency instance;
    private Currency currency;
    private ProviderFromNBRB provider;


    private CashCurrency() {
        this.provider = new ProviderFromNBRB();
        this.currency = provider.getNowCurrency();
    }

    public static CashCurrency getInstance() {
        CashCurrency result = instance;
        if (result != null) {
            return result;
        }
        synchronized (CashCurrency.class) {
            if (result == null) {
                instance = new CashCurrency();
            }
            return instance;
        }
    }

    public Currency getCurrency() {
        return currency;
    }

    public void updateCurrency() {
        this.currency = provider.getNowCurrency();
    }
}
