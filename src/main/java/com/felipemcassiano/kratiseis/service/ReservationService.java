package com.felipemcassiano.kratiseis.service;

import com.felipemcassiano.kratiseis.exceptions.DateConflictException;
import com.felipemcassiano.kratiseis.model.Reservation.Reservation;
import com.felipemcassiano.kratiseis.model.Reservation.CreateReservationDTO;
import com.felipemcassiano.kratiseis.model.Resource.Resource;
import com.felipemcassiano.kratiseis.model.User.User;
import com.felipemcassiano.kratiseis.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserService userService;
    private final ResourceService resourceService;
    private final DateService dateService;

    public ReservationService(ReservationRepository reservationRepository, UserService userService, ResourceService resourceService, DateService dateService) {
        this.reservationRepository = reservationRepository;
        this.userService = userService;
        this.resourceService = resourceService;
        this.dateService = dateService;
    }

    public Reservation findById(Long id) {
        return reservationRepository.findById(id).get();
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Transactional
    public void createReservation(CreateReservationDTO request) {

        if (!dateService.validateDates(request.startDate(), request.endDate())){
            throw new DateConflictException("invalid dates");
        }

        Resource resource = resourceService.findById(request.resourceId());


        for (Reservation r : resource.getReservations()){
            if (!dateService.datesDoesNotOverlap(r.getStartTime(), r.getEndTime(), request.startDate(), request.endDate())){
                throw new DateConflictException("dates overlapping");
            }
        }

        User user = userService.findById(request.userId());

        Reservation reservation = new Reservation(request);
        reservation.setUser(user);
        reservation.setResource(resource);

        user.getReservations().add(reservation);
        reservationRepository.save(reservation);
        userService.updateUser(user);
        resourceService.saveResource(resource);
    }
    @Transactional
    public void updateReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
    public void deleteReservation(long id) {
        reservationRepository.deleteById(id);
    }

}
