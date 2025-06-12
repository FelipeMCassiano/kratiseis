package com.felipemcassiano.kratiseis.repository;

import com.felipemcassiano.kratiseis.model.User.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {
}
