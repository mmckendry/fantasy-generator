package com.genodyme.name.generator.service;

import com.genodyme.name.generator.domain.FantasyLocationResponse;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Implementation of Name Generation Service
 */
@Service
public class FantasyLocationServiceImpl implements FantasyLocationService {

    private static final String COMMA_DELIMITER = ",";
    private static final String PREFIX_FILENAME = "prefix.csv";
    private static final String SUFFIX_FILENAME = "suffix.csv";
    private static final String URL = "/opt/resources/";
    private static final String TEST_URL = "./";

    private static final String DESCRIPTION = "A tumult of wild noises, which were caused by insects and critters," +
            " reverberated through the air, and drowned out the occasional sounds of breaking twigs beneath" +
            " the feet of larger animals.";
    public FantasyLocationResponse generateLocation() {
        return new FantasyLocationResponse(buildName(), DESCRIPTION, "/assets/images/evening-bayou.jpg");
    }

    private String buildName() {
        List<List<String>> prefixList = prefixArray(PREFIX_FILENAME);
        List<List<String>> suffixList = prefixArray(SUFFIX_FILENAME);

        String prefixName = retrieveNameSegment(simplifyList(prefixList));
        String suffixName = retrieveNameSegment(simplifyList(suffixList));

        return prefixName + suffixName.toLowerCase();
    }

    private String retrieveNameSegment(List<String> nameArray) {
        Random rand = new SecureRandom();
        return nameArray.get(rand.nextInt(nameArray.size() - 1));
    }

    private List<List<String>> prefixArray(String filename) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(TEST_URL + filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
            return records;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> simplifyList(List<List<String>> complextList) {
        return complextList.stream().flatMap(List::stream).toList();
    }
}
