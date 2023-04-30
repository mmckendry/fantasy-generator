package com.genodyme.name.generator.controller;

import com.genodyme.name.generator.service.NameGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameGenerationController {

    @Autowired
    NameGenerationService nameGenerationService;

    @CrossOrigin(origins = "http://martinmckendry.com")
    @GetMapping(value = "/generate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> generateName() {
        return new ResponseEntity<>(nameGenerationService.generateName(), HttpStatus.CREATED);
    }
}
