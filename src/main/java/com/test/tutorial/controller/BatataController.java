package com.test.tutorial.controller;

import com.test.tutorial.model.BatataDto;
import com.test.tutorial.service.BatataService;
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
    public ResponseEntity<List<BatataDto>> getAll(){
        logger.info("Get all Batatas");
        return ResponseEntity.ok(batataService.findAll());
    }

    @ApiOperation(value = "Simple find all batatas")
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE },
            method = RequestMethod.GET ,path = "/count")
    public ResponseEntity<Long> count(){
        logger.info("Get how many Batatas");
        return ResponseEntity.ok(batataService.count());
    }

    @ApiOperation(value = "Simple find all batatas by type")
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE },
                      method = RequestMethod.GET,
                      path   = "/ids/{ids}" )
    public ResponseEntity<List<BatataDto>> getByIds(@ApiParam(name = "ids", value = "Batata ids", required = true)
                                                    @PathVariable(value = "ids", required = true) List<Integer> ids) {
        logger.info("Get all Batatas by ids");
        return ResponseEntity.ok(batataService.findIds(ids));
    }

    @ApiOperation(value = "Simple find all batatas by type")
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE },
            method = RequestMethod.GET,
            path   = "/type/{type}" )
    public ResponseEntity<List<BatataDto>> getByType(@ApiParam(name = "type", value = "Batata type", required = true)
                                                     @PathVariable(value = "type", required = true) String type) {
        logger.info("Get all Batatas by type");
        return ResponseEntity.ok(batataService.findType(type));
    }

    @ApiOperation(value = "Simple find one batata")
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
                      method = RequestMethod.GET,
                        path = "/{id}")
    public ResponseEntity<BatataDto> getById(@ApiParam(name = "id", value = "Batata id", required = true)
                                             @PathVariable(value = "id", required = true) Integer id) {
        logger.info("Get a batata by Id:" + id);
        BatataDto result = batataService.findOne(id);

        if(result != null){
            return ResponseEntity.ok(result);
        } else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                                  .build();
        }


    }

    @ApiOperation(value = "Create a simple batata")
    @PostMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE },
                 consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public BatataDto create(@ApiParam(name = "Batata", value = "Batata to be saved", required = true)
                            @Validated @RequestBody BatataDto batata) {

        return batataService.save(batata);
    }

    @ApiOperation(value = "Create a simple batata")
    @PutMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE },
                consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE},
                    path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BatataDto> update(@ApiParam(name = "id", value = "Batata id", required = true)
                                            @PathVariable(value = "id", required = true) Integer id,
                                            @ApiParam(name = "Batata", value = "Batata to be updated", required = true)
                                            @Validated
                                            @RequestBody BatataDto batata) {

        BatataDto result =  batataService.update(id, batata);
        if(result != null){
            return ResponseEntity.ok(result);
        } else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping(path = "/{id}",
               produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Delete a batata")
    public ResponseEntity delete(@ApiParam(name = "id", value = "Batata id", required = true)
                                 @PathVariable(value = "id", required = true) Integer id) {
        batataService.delete(id);
        return ResponseEntity.ok().build();
    }
}
