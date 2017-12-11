package com.test.tutorial.service;

import com.google.common.collect.Lists;
import com.test.tutorial.model.entity.Batata;
import com.test.tutorial.repository.BatataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatataService {
    private static Logger logger = LoggerFactory.getLogger(BatataService.class);
    private BatataRepository BatataRepository;

    @Autowired
    public BatataService(BatataRepository BatataRepository){
        this.BatataRepository = BatataRepository;
    }

    public Batata findOne(Integer id){
        logger.debug("find:" + id);
        return BatataRepository.findOne(id);
    }

    public List<Batata> findAll(){
        Iterable result = BatataRepository.findAll();
        logger.debug("returning: " + result);
        return Lists.newArrayList(result);
    }

    public List<Batata> findDescriptionBatata(String type){
        Iterable result = BatataRepository.findByType(type);
        logger.debug("List all Batata with type: " + type);
        return Lists.newArrayList(result);
    }

    public Batata save(Batata Batata){
        logger.debug("Saving: " + Batata);
        return BatataRepository.save(Batata);
    }

    public void delete(Integer id){
        logger.debug("Removing: " + id);
        BatataRepository.delete(id);
    }
}
