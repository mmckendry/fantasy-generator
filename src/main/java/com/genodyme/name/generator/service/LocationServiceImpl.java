package com.genodyme.name.generator.service;

import com.genodyme.name.generator.domain.LocationRequest;
import com.genodyme.name.generator.domain.LocationResponse;
import com.genodyme.name.generator.respository.LocationRepository;
import com.genodyme.name.generator.utility.CSVFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static com.genodyme.name.generator.constants.LocationConstants.DESCRIPTION_INFIX_FILENAME;
import static com.genodyme.name.generator.constants.LocationConstants.DESCRIPTION_PREFIX_FILENAME;
import static com.genodyme.name.generator.constants.LocationConstants.DESCRIPTION_SUFFIX_FILENAME;
import static com.genodyme.name.generator.constants.LocationConstants.IMAGES_FILENAME;
import static com.genodyme.name.generator.constants.LocationConstants.IMAGE_URL_TEST;
import static com.genodyme.name.generator.constants.LocationConstants.LOCATION_BASE_URL_TEST;
import static com.genodyme.name.generator.constants.LocationConstants.PREFIX_FILENAME;
import static com.genodyme.name.generator.constants.LocationConstants.SUFFIX_FILENAME;

/**
 * Implementation of Location Service
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public LocationResponse generateLocation() {
        LocationRequest locationRequest = new LocationRequest(buildId(), buildName(), buildDescription(), buildImageUrl());
        return createFantasyLocation(locationRequest);
    }

    private UUID buildId() {
        return UUID.randomUUID();
    }

    private String buildName() {
        List<List<String>> prefixList = CSVFileReader.readFromCSV(PREFIX_FILENAME, LOCATION_BASE_URL_TEST);
        List<List<String>> suffixList = CSVFileReader.readFromCSV(SUFFIX_FILENAME, LOCATION_BASE_URL_TEST);

        String prefixName = retrieveStringSegment(simplifList(prefixList));
        String suffixName = retrieveStringSegment(simplifList(suffixList));

        return prefixName + suffixName.toLowerCase();
    }

    private String buildDescription() {
        
        List<List<String>> prefixList = CSVFileReader.readFromCSV(DESCRIPTION_PREFIX_FILENAME, LOCATION_BASE_URL_TEST);
        List<List<String>> infixList = CSVFileReader.readFromCSV(DESCRIPTION_INFIX_FILENAME, LOCATION_BASE_URL_TEST);
        List<List<String>> suffixList = CSVFileReader.readFromCSV(DESCRIPTION_SUFFIX_FILENAME, LOCATION_BASE_URL_TEST);

        String descriptionPrefix = retrieveStringSegment(simplifList(prefixList));
        String descriptionInfix = retrieveStringSegment(simplifList(infixList));
        String descriptionSuffix = retrieveStringSegment(simplifList(suffixList));

        return descriptionPrefix + ", " + descriptionInfix + ", " + descriptionSuffix;
    }

    private String buildImageUrl() {
        List<List<String>> imageUrls = CSVFileReader.readFromCSV(IMAGES_FILENAME, IMAGE_URL_TEST);
        return retrieveStringSegment(simplifList(imageUrls));
    }

    private String retrieveStringSegment(List<String> nameArray) {
        Random rand = new SecureRandom();
        return nameArray.get(rand.nextInt(nameArray.size() - 1));
    }

    private List<String> simplifList(List<List<String>> complextList) {
        return complextList.stream().flatMap(List::stream).toList();
    }

    public LocationResponse createFantasyLocation(LocationRequest locationRequest) {
        locationRepository.save(locationRequest);
        return getLocationByName(locationRequest.getName());
    }

    public LocationResponse getLocationByName(String name) {
        return locationRepository.findLocationByName(name);
    }

    public LocationResponse getLocationById(UUID id) {
        return locationRepository.findLocationById(id);
    }

}
