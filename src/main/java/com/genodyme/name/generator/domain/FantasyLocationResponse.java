package com.genodyme.name.generator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Fantasy Location Response
 */
@Data
@AllArgsConstructor
public class FantasyLocationResponse {
  private String name;
  private String description;
  private String imageUrl;
}
