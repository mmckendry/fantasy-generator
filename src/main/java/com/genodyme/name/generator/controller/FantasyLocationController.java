package com.genodyme.name.generator.controller;

import com.genodyme.name.generator.domain.FantasyLocationResponse;
import com.genodyme.name.generator.service.FantasyLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FantasyLocationController {

    @Autowired
    FantasyLocationService fantasyLocationService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/location", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<FantasyLocationResponse> generateLocation() {
        return new ResponseEntity<>(fantasyLocationService.generateLocation(), HttpStatus.OK);
    }
}
