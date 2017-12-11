package com.test.tutorial.controller;

import com.test.tutorial.model.Example;
import com.test.tutorial.model.entity.Batata;
import com.test.tutorial.service.BatataService;
import com.test.tutorial.service.ExamplesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping("batata")
@Api(value = "Batatas", description = "Simple example controller with database", tags = "Batata")
public class BatataController {
    private static Logger logger = LoggerFactory.getLogger(BatataController.class);

    private BatataService batataService;

    @Autowired
    public BatataController(BatataService batataService) {
        this.batataService = batataService;
    }

    @ApiOperation(value = "Simple find all batatas")
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE },
                      method = RequestMethod.GET)
    public ResponseEntity<List<Batata>> getAll(){
        logger.info("Get all Batatas");
        return ResponseEntity.ok(batataService.findAll());
    }

    @ApiOperation(value = "Simple find one batata")
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
                      method = RequestMethod.GET,
                        path = "/{id}")
    public ResponseEntity<Batata> getById(@ApiParam(name = "id", value = "Batata id", required = true)
                          @PathVariable(value = "id", required = true) Integer id) {
        logger.info("Get a batata by Id:" + id);
        Batata result = batataService.findOne(id);

        if(result != null){
            return ResponseEntity.ok(result);
        } else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                                  .build();
        }


    }


    @ApiOperation(value = "Create a simple batata")
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE },
                    consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE},
                      method = RequestMethod.POST)
    public Batata create(@ApiParam(name = "Batata", value = "Batata to be saved", required = true)
                         @Validated
                         @RequestBody Batata batata){

        return batataService.save(batata);
    }

    @RequestMapping(path = "/{id}",
                  method = RequestMethod.DELETE,
                produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Delete a batata")
    public ResponseEntity delete(@ApiParam(name = "id", value = "Batata id", required = true)
                                @PathVariable(value = "id", required = true) Integer id) {
        batataService.delete(id);
        return ResponseEntity.ok().build();
    }
}
