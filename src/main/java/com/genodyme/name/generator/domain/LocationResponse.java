package com.genodyme.name.generator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

/**
 * Fantasy Location Response
 */
@Data
@AllArgsConstructor
public class LocationResponse {

  private UUID id;

  private String name;

  private String description;

  private String imageUrl;

}
