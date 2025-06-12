package com.felipemcassiano.kratiseis.service;

import com.felipemcassiano.kratiseis.exceptions.UserNotFoundException;
import com.felipemcassiano.kratiseis.model.Reservation.Reservation;
import com.felipemcassiano.kratiseis.model.Reservation.ResponseReservationDTO;
import com.felipemcassiano.kratiseis.model.User.ResponseUserDTO;
import com.felipemcassiano.kratiseis.model.User.User;
import com.felipemcassiano.kratiseis.model.User.CreateUserDTO;
import com.felipemcassiano.kratiseis.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findById(long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) return user.get();

        throw new UserNotFoundException("not found user with id: " + id);
    }

    public List<ResponseUserDTO> findAll() {
        return userRepository.findAll().stream().map(u -> new ResponseUserDTO(u.getId(), u.getUsername(), u.getReservations().stream().map(r -> new ResponseReservationDTO(r.getId(), r.getUser().getUsername(), r.getResource().getName(),r.getStartTime(), r.getEndTime())).toList())).toList();
    }

    public List<Reservation> getReservationsByUserId(long id) {
        User user = findById(id);

        return user.getReservations();
    }

    @Transactional
    public void saveUser(CreateUserDTO dto) {
        User user = new User(dto);
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user) {
        userRepository.save(user);
    }


    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
