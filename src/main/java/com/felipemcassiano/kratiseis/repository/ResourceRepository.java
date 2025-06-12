package com.felipemcassiano.kratiseis.repository;

import com.felipemcassiano.kratiseis.model.Resource.Resource;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends ListCrudRepository<Resource, Long> {

}
