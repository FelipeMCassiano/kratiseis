package com.felipemcassiano.kratiseis.repository;

import com.felipemcassiano.kratiseis.model.Reservation.Reservation;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends ListCrudRepository<Reservation, Long> {
}
