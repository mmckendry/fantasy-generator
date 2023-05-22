package com.genodyme.name.generator.service;

import com.genodyme.name.generator.domain.FantasyLocationRequest;
import com.genodyme.name.generator.domain.FantasyLocationResponse;

/**
 * Service to generate fantasy place names
 */
public interface FantasyLocationService {
    FantasyLocationResponse generateLocation();

    FantasyLocationResponse getLocationByName(String name);

    FantasyLocationResponse createFantasyLocation(FantasyLocationRequest fantasyLocationRequest);

}
