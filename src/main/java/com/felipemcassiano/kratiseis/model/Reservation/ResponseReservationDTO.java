package com.felipemcassiano.kratiseis.model.Reservation;


import java.time.LocalDateTime;

public record ResponseReservationDTO(
        Long id,
        String resourceName,
        String userName,
        LocalDateTime startTime,
        LocalDateTime endTime
) {}
