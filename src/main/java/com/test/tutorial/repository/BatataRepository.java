package com.test.tutorial.repository;

import com.test.tutorial.model.entity.Batata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * A example of repository
 */
@Repository
public interface BatataRepository extends CrudRepository<Batata, Integer> {

    /**
     * This shows a example how spring works with queries from method name
     * @param type a simple string
     * @return list of batatas
     * @apiNote examples on: https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-creating-database-queries-from-method-names/
     */
    Set<Batata> findByTypeLike(String type);

    /**
     * this show another example of query created with method's name, this time using a in.
     * @param ids list of ids
     * @return list of babata object
     */
    Set<Batata> findByIdIn(List<Integer> ids);
}
