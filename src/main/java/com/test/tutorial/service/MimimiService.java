package com.test.tutorial.service;

import com.google.common.collect.Lists;
import com.test.tutorial.model.entity.Mimimi;
import com.test.tutorial.repository.MimimiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MimimiService {
    private static Logger logger = LoggerFactory.getLogger(MimimiService.class);
    private MimimiRepository mimimiRepository;

    @Autowired
    public MimimiService(MimimiRepository mimimiRepository){
        this.mimimiRepository = mimimiRepository;
    }

    public Mimimi findOne(Integer id){
        logger.debug("find:" + id);
        return mimimiRepository.findOne(id);
    }

    public List<Mimimi> findAll(){
        Iterable result = mimimiRepository.findAll();
        logger.debug("returning: " + result);
        return Lists.newArrayList(result);
    }

    public List<Mimimi> findDescriptionMimimi(String desc){
        Iterable result = mimimiRepository.findByDescriptionMimimi(desc);
        logger.debug("List all mimimi with desc: " + desc);
        return Lists.newArrayList(result);
    }

    public Mimimi save(Mimimi mimimi){
        logger.debug("Saving: " + mimimi);
        return mimimiRepository.save(mimimi);
    }

    public void delete(Mimimi mimimi){
        logger.debug("Removing: " + mimimi);
        mimimiRepository.delete(mimimi.getId());
    }
}
