package com.genodyme.name.generator.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Model for Location Requests
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationRequest {
  @Id
  @GeneratedValue
  private UUID id;

  private String name;

  private String description;

  private String imageUrl;

}
