package com.genodyme.name.generator.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FantasyLocationRequest {
  @Id
  @GeneratedValue
  private UUID id;

  private String name;

  private String description;

  private String imageUrl;

}
