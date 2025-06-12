package com.felipemcassiano.kratiseis.model.User;

import com.felipemcassiano.kratiseis.model.Reservation.Reservation;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    public User() {

    }

    public User(CreateUserDTO userDTO) {
        this.username = userDTO.username();
    }

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
