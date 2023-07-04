package com.genodyme.name.generator.service;

import com.genodyme.name.generator.domain.FantasyLocationRequest;
import com.genodyme.name.generator.domain.FantasyLocationResponse;

import java.util.UUID;

/**
 * Service to generate fantasy place names
 */
public interface FantasyLocationService {
    FantasyLocationResponse generateLocation();

    FantasyLocationResponse getLocationByName(String name);

    FantasyLocationResponse createFantasyLocation(FantasyLocationRequest fantasyLocationRequest);

    FantasyLocationResponse getLocationById(UUID id);

}
