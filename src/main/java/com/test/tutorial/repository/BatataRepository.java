package com.test.tutorial.repository;

import com.test.tutorial.model.entity.Batata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BatataRepository extends CrudRepository<Batata, Integer> {

    @Override
    Batata findOne(Integer integer);

    Set<Batata> findByType(String type);
}
