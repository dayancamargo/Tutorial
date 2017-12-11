package com.test.tutorial.service;

import com.test.tutorial.model.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ExamplesService {
    private static Logger logger = LoggerFactory.getLogger(ExamplesService.class);

    private List<Example> exampleList;

    public  ExamplesService(){
        exampleList = new ArrayList();
        exampleList.add(new Example("name#1", "something", 10));
        exampleList.add(new Example("name#2", "batata", 30));
        exampleList.add(new Example("name#3", "meh", 0));

        logger.debug("Initial example list:" + exampleList);
    }

    public List<Example> getExampleList(){
        logger.debug("Example list:" + exampleList);
        return exampleList;
    }

    public List<Example> create(Example example){
        logger.debug("saving an example:" + example);
        example.setId(new Random().nextInt());
        exampleList.add(example);
        return exampleList;
    }

    public List<Example> delete(Integer id){
        Integer index = null;
        Example toRemove = exampleList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst().orElseGet(null);
        if(toRemove != null){
            logger.debug("Removing an example: " +toRemove);
            exampleList.remove(toRemove);
        }

        return exampleList;
    }
}
