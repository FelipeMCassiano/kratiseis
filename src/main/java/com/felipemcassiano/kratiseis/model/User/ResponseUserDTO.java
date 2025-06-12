package com.felipemcassiano.kratiseis.model.User;

import com.felipemcassiano.kratiseis.model.Reservation.ResponseReservationDTO;

import java.util.List;

public record ResponseUserDTO(long id, String username, List<ResponseReservationDTO> reservations) {
}
