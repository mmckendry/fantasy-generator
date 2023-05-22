package com.genodyme.name.generator.controller;

import com.genodyme.name.generator.domain.FantasyLocationRequest;
import com.genodyme.name.generator.domain.FantasyLocationResponse;
import com.genodyme.name.generator.service.FantasyLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FantasyLocationController {

    @Autowired
    FantasyLocationService fantasyLocationService;

    @CrossOrigin(origins = "http://martinmckendry.com")
    @GetMapping(value = "/location", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<FantasyLocationResponse> generateLocation() {
        return new ResponseEntity<>(fantasyLocationService.generateLocation(), HttpStatus.OK);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<FantasyLocationResponse> createLocation(@RequestBody FantasyLocationRequest fantasyLocationRequest) {
        return new ResponseEntity<>(fantasyLocationService.createFantasyLocation(fantasyLocationRequest), HttpStatus.CREATED);
    }

    @GetMapping(value = "/getByName", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody

    public ResponseEntity<FantasyLocationResponse> getLocationByName(@RequestParam String name) {
        return new ResponseEntity<>(fantasyLocationService.getLocationByName(name), HttpStatus.OK);
    }

}
