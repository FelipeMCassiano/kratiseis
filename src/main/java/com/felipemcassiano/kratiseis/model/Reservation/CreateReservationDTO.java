package com.felipemcassiano.kratiseis.model.Reservation;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record CreateReservationDTO(
        Long userId,
        Long resourceId,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime startDate,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime endDate
) {}
