package com.genodyme.name.generator.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FantasyLocationResponseHelper {
  private static final String COMMA_DELIMITER = ",";
  private FantasyLocationResponseHelper(){}

  public static List<List<String>> readFromCSV(String filename, String url) {
    List<List<String>> records = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(url + filename))) {
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

}
