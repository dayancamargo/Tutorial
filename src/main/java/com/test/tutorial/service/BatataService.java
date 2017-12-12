package com.test.tutorial.service;

import com.test.tutorial.model.BatataDto;
import com.test.tutorial.model.entity.Batata;
import com.test.tutorial.repository.BatataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * A example of service class
 */
@Service
public class BatataService {
    private static Logger logger = LoggerFactory.getLogger(BatataService.class);
    private BatataRepository batataRepository;

    @Autowired
    public BatataService(BatataRepository BatataRepository){
        this.batataRepository = BatataRepository;
    }

    public BatataDto findOne(Integer id){
        logger.debug("find:" + id);
        Batata ent= batataRepository.findOne(id);
        return (ent != null ? ent.dto() : null);
    }

    public List<BatataDto> findAll(){
        List<BatataDto> dtos = new ArrayList<>();
        Iterable<Batata> result = batataRepository.findAll();
        logger.debug("returning: " + result);
        if(result != null ) {
            logger.debug("List all Batatas");
            result.forEach(ent -> {
                dtos.add(ent.dto());
            });
        }
        return dtos;
    }

    /**
     * Get a list of batatas searching by type (like)
     * @param type a string to search
     * @return a list of batatas
     */
    public List<BatataDto> findType(String type){
        List<BatataDto> dtos = new ArrayList<>();
        Iterable<Batata> result = batataRepository.findByTypeLike("%" + type + "%");
        if(result != null ) {
            logger.debug("List all Batata with type: " + type);
            result.forEach(ent -> {
                dtos.add(ent.dto());
            });
        }
        return dtos;
    }

    public List<BatataDto> findIds(List<Integer> ids){
        List<BatataDto> dtos = new ArrayList<>();
        Iterable<Batata> result = batataRepository.findByIdIn(ids);
        if(result != null ) {
            logger.debug("List all Batata with ids: " + ids);
            result.forEach(ent ->{
                    dtos.add(ent.dto());
            });
        }
        return dtos;
    }

    public BatataDto save(BatataDto batata){
        logger.debug("Saving: " + batata);
        return batataRepository.save(new Batata(batata)).dto();
    }

    public void delete(Integer id){
        logger.debug("Removing: " + id);
        batataRepository.delete(id);
    }

    /**
     * Remove all batatas from db
     */
    public void deleteAll(){
        logger.debug("Removing all batatas");
        batataRepository.deleteAll();
    }

    /**
     * Example of how to make a count call on BD
     * @return Number of batatas
     */
    public  Long count(){
        logger.debug("Get how many batatas we have");
        return batataRepository.count();
    }

    public BatataDto update(Integer id, BatataDto batata) {
        BatataDto toUpdate = findOne(id);

        if( toUpdate != null ) {
            return batataRepository.save(new Batata(id, batata)).dto();
        }

        throw new RuntimeException("Batata not found to update.");
    }
}
