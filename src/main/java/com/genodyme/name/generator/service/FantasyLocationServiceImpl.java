package com.genodyme.name.generator.service;

import com.genodyme.name.generator.domain.FantasyLocationRequest;
import com.genodyme.name.generator.domain.FantasyLocationResponse;
import com.genodyme.name.generator.respository.FantasyLocationRepository;
import com.genodyme.name.generator.utility.FantasyLocationResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static com.genodyme.name.generator.constants.FantasyLocationConstants.DEFAULT_DESCRIPTION;
import static com.genodyme.name.generator.constants.FantasyLocationConstants.IMAGES_FILENAME;
import static com.genodyme.name.generator.constants.FantasyLocationConstants.IMAGE_URL;
import static com.genodyme.name.generator.constants.FantasyLocationConstants.IMAGE_URL_TEST;
import static com.genodyme.name.generator.constants.FantasyLocationConstants.LOCATION_BASE_URL_TEST;
import static com.genodyme.name.generator.constants.FantasyLocationConstants.PREFIX_FILENAME;
import static com.genodyme.name.generator.constants.FantasyLocationConstants.SUFFIX_FILENAME;

/**
 * Implementation of Name Generation Service
 */
@Service
public class FantasyLocationServiceImpl implements FantasyLocationService {

    @Autowired
    private FantasyLocationRepository fantasyLocationRepository;

    public FantasyLocationResponse generateLocation() {
        FantasyLocationRequest fantasyLocationRequest = new FantasyLocationRequest(buildId(), buildName(), buildDescription(), buildImageUrl());
        return createFantasyLocation(fantasyLocationRequest);
    }

    private UUID buildId() {
        return UUID.randomUUID();
    }
    private String buildName() {
        List<List<String>> prefixList = FantasyLocationResponseHelper.readFromCSV(PREFIX_FILENAME, LOCATION_BASE_URL_TEST);
        List<List<String>> suffixList = FantasyLocationResponseHelper.readFromCSV(SUFFIX_FILENAME, LOCATION_BASE_URL_TEST);

        String prefixName = retrieveNameSegment(simplifList(prefixList));
        String suffixName = retrieveNameSegment(simplifList(suffixList));

        return prefixName + suffixName.toLowerCase();
    }

    private String buildDescription() {
        return DEFAULT_DESCRIPTION;
    }

    private String buildImageUrl() {
        List<List<String>> imageUrls = FantasyLocationResponseHelper.readFromCSV(IMAGES_FILENAME, IMAGE_URL_TEST);
        return retrieveNameSegment(simplifList(imageUrls));
    }

    private String retrieveNameSegment(List<String> nameArray) {
        Random rand = new SecureRandom();
        return nameArray.get(rand.nextInt(nameArray.size() - 1));
    }

    private List<String> simplifList(List<List<String>> complextList) {
        return complextList.stream().flatMap(List::stream).toList();
    }

    public FantasyLocationResponse createFantasyLocation(FantasyLocationRequest fantasyLocationRequest) {
        fantasyLocationRepository.save(fantasyLocationRequest);
        return getLocationByName(fantasyLocationRequest.getName());
    }

    public FantasyLocationResponse getLocationByName(String name) {
        return fantasyLocationRepository.findLocationByName(name);
    }

    public FantasyLocationResponse getLocationById(UUID id) {
        return fantasyLocationRepository.findLocationById(id);
    }

}
