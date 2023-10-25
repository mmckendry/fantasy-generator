package com.genodyme.name.generator.service;

import com.genodyme.name.generator.domain.LocationRequest;
import com.genodyme.name.generator.domain.LocationResponse;

import java.util.UUID;

/**
 * Service to generate locations
 */
public interface LocationService {
    LocationResponse generateLocation();

    LocationResponse getLocationByName(String name);

    LocationResponse createFantasyLocation(LocationRequest fantasyLocationRequest);

    LocationResponse getLocationById(UUID id);

}
