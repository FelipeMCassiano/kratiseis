package com.felipemcassiano.kratiseis.model.Resource;

import com.felipemcassiano.kratiseis.model.Reservation.Reservation;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "resource")
    private List<Reservation> Reservations;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reservation> getReservations() {
        return Reservations;
    }
}
