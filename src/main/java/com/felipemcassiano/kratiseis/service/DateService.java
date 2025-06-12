package com.felipemcassiano.kratiseis.service;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class DateService {
    public  boolean validateDates(LocalDateTime startDate, LocalDateTime endDate) {
        boolean isBefore = startDate.isBefore(endDate);
        boolean has1HourBetweenStartAndEndDate = Duration.between(startDate, endDate).toHours() >= 1;
        return isBefore && has1HourBetweenStartAndEndDate ;
    }
    public boolean datesDoesNotOverlap(LocalDateTime startDate1, LocalDateTime endDate1, LocalDateTime startDate2, LocalDateTime endDate2) {
        return !startDate1.isAfter(endDate2) && !startDate2.isAfter(endDate1);
    }
}
