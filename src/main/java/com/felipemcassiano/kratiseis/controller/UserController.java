package com.felipemcassiano.kratiseis.controller;

import com.felipemcassiano.kratiseis.model.Reservation.Reservation;
import com.felipemcassiano.kratiseis.model.User.ResponseUserDTO;
import com.felipemcassiano.kratiseis.model.User.User;
import com.felipemcassiano.kratiseis.model.User.CreateUserDTO;
import com.felipemcassiano.kratiseis.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<ResponseUserDTO>> getAllUsers() {
        List<ResponseUserDTO> users = userService.findAll();
        return ResponseEntity.ok(users);

    }
    @GetMapping("{id}/reservations")
    public ResponseEntity<List<Reservation>> getReservationsByUserId(@PathVariable long id) {
        List<Reservation> reservations = userService.getReservationsByUserId(id);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDTO userDTO) {
        userService.saveUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
