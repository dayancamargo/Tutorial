package com.test.tutorial.controller;


import com.test.tutorial.model.Example;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("examples")
@Api(value = "Example", description = "Simple example controller", tags = "Example")
public class ExampleController {
    private static Logger logger = LoggerFactory.getLogger(ExampleController.class);

    private List<Example> exampleList;

    public ExampleController() {
        exampleList = new ArrayList();
        exampleList.add(new Example("name#1", "something", 10));
        exampleList.add(new Example("name#2", "batata", 30));
        exampleList.add(new Example("name#3", "meh", 0));

        logger.debug("Initial example list:" + exampleList);
    }

    @ApiOperation(value = "Simple find all")
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, //this return will be parsed to json
                      method = RequestMethod.GET)               //this method is a get http operation
    public ResponseEntity<List<Example>> getAll(){
        logger.info("Get all examples");
        return ResponseEntity.ok(exampleList);
    }

    @ApiOperation(value = "Simple find all - Obejct")
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE },
                      method = RequestMethod.GET,
                        path = "/object")
    public List<Example> getAllObject() {
        logger.info("Get all examples - Object");
        return exampleList;
    }

    @ApiOperation(value = "Simple find all - Generic")
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE },
                      method = RequestMethod.GET,
                        path = "/generic")
    public ResponseEntity<?> getAllGeneric(){
        logger.info("Get all examples - Generic");
        return ResponseEntity.ok(exampleList);
    }

    @ApiOperation(value = "Simple find all - Obejct")
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE },
                    consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE},  //this return will be parsed to json
                      method = RequestMethod.POST)              //this method is a post http operation
    public List<Example> create(@ApiParam(name = "Example", value = "Example to be saved", required = true)  // used in swagger, describes a parameter
                                @Validated // validate all 'constraints'
                                @RequestBody Example example){ // a object to be used, this will try parse a json/txt/xml (consumes define) to a object
        example.setId(new Random().nextInt());
        logger.debug("saving an example:" + example);
        exampleList.add(example);
        return exampleList;
    }

    @RequestMapping(path = "/{id}",
                  method = RequestMethod.DELETE,
                produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Delete a example")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT) //this will define which status code will return
    public List<Example> delete(@ApiParam(name = "id", value = "Example id", required = true)
                                @PathVariable(value = "id", required = true) Integer id) { //this will map a request var from uri. Required default value is true.
        Integer index = null;
        Example toRemove = exampleList.stream()
                                       .filter(e -> e.getId().equals(id))
                                       .findFirst().orElseGet(null);
        if(toRemove != null){
            logger.debug("Removing an example: " +toRemove);
            exampleList.remove(toRemove);
        }

        return  exampleList;
    }
}
