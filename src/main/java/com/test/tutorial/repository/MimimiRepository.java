package com.test.tutorial.repository;

import com.test.tutorial.model.entity.Batata;
import com.test.tutorial.model.entity.Mimimi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MimimiRepository extends CrudRepository<Mimimi, Integer> {

    @Override
    Mimimi findOne(Integer integer);
    Set<Mimimi> findByDescriptionMimimi(String desc);
}
