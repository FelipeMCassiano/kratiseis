package com.felipemcassiano.kratiseis.controller;

import com.felipemcassiano.kratiseis.model.Reservation.Reservation;
import com.felipemcassiano.kratiseis.model.Reservation.CreateReservationDTO;
import com.felipemcassiano.kratiseis.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")

public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> all = reservationService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody CreateReservationDTO dto) {

        reservationService.createReservation(dto);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
