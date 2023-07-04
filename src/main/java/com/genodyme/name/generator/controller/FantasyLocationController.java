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

import java.util.UUID;

@RestController
public class FantasyLocationController {

    @Autowired
    FantasyLocationService fantasyLocationService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/location", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FantasyLocationResponse generateLocation() {
      return fantasyLocationService.generateLocation();
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<FantasyLocationResponse> createLocation(@RequestBody FantasyLocationRequest fantasyLocationRequest) {
        return new ResponseEntity<>(fantasyLocationService.createFantasyLocation(fantasyLocationRequest), HttpStatus.CREATED);
    }

    @GetMapping(value = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FantasyLocationResponse getLocationByName(@RequestParam String name) {
        return fantasyLocationService.getLocationByName(name);
    }

    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FantasyLocationResponse getLocationById(@RequestParam UUID id) {
        return fantasyLocationService.getLocationById(id);
    }

}
