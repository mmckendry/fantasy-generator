package com.genodyme.name.generator.controller;

import com.genodyme.name.generator.domain.LocationRequest;
import com.genodyme.name.generator.domain.LocationResponse;
import com.genodyme.name.generator.service.LocationService;
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

/**
 * Location Controller
 */
@RestController
public class LocationController {

    @Autowired
    LocationService locationService;

//    @CrossOrigin(origins = "http://martinmckendry.com")
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/location", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LocationResponse generateLocation() {
      return locationService.generateLocation();
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<LocationResponse> createLocation(@RequestBody LocationRequest locationRequest) {
        return new ResponseEntity<>(locationService.createFantasyLocation(locationRequest), HttpStatus.CREATED);
    }

    @GetMapping(value = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LocationResponse getLocationByName(@RequestParam String name) {
        return locationService.getLocationByName(name);
    }

    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LocationResponse getLocationById(@RequestParam UUID id) {
        return locationService.getLocationById(id);
    }

}
