package by.v.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledTasks {

    @Autowired
    private CashCurrency cashValue;

    @Scheduled(fixedRate = 43200) // обновление значения через 12 часов.
    public void reportCurrentTime() {
        cashValue.updateCurrency();
    }
}
