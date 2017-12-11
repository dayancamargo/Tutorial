package com.test.tutorial.controller;


import com.test.tutorial.model.Example;
import com.test.tutorial.service.ExamplesService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("examples")
@Api(value = "Example", description = "Simple example controller", tags = "Example")
public class ExampleController {
    private static Logger logger = LoggerFactory.getLogger(ExampleController.class);

    private ExamplesService examplesService;

    @Autowired
    public ExampleController(ExamplesService examplesService) {
        this.examplesService = examplesService;
    }

    @ApiOperation(value = "Simple find all")
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, //this return will be parsed to json
                      method = RequestMethod.GET)                         //this method is a get http operation
    public ResponseEntity<List<Example>> getAll(){
        logger.info("Get all examples");
        return ResponseEntity.ok(examplesService.getExampleList());
    }

    @ApiOperation(value = "Simple find all - Obejct")
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE },
                      method = RequestMethod.GET,
                        path = "/object")
    public List<Example> getAllObject() {
        logger.info("Get all examples - Object");
        return examplesService.getExampleList();
    }

    @ApiOperation(value = "Simple find all - Generic")
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE },
                      method = RequestMethod.GET,
                        path = "/generic")
    public ResponseEntity<?> getAllGeneric(){
        logger.info("Get all examples - Generic");
        return ResponseEntity.ok(examplesService.getExampleList());
    }

    @ApiOperation(value = "Simple find all - Obejct")
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE },
                    consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE},  //this return will be parsed to json
                      method = RequestMethod.POST)              //this method is a post http operation
    public List<Example> create(@ApiParam(name = "Example", value = "Example to be saved", required = true)  // used in swagger, describes a parameter
                                @Validated // validate all 'constraints'
                                @RequestBody Example example){ // a object to be used, this will try parse a json/txt/xml (consumes define) to a object

        return examplesService.create(example);
    }

    @RequestMapping(path = "/{id}",
                  method = RequestMethod.DELETE,
                produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Delete a example")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT) //this will define which status code will return
    public List<Example> delete(@ApiParam(name = "id", value = "Example id", required = true)
                                @PathVariable(value = "id", required = true) Integer id) { //this will map a request var from uri. Required default value is true.

        return  examplesService.delete(id);
    }
}
