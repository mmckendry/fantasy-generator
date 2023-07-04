package com.genodyme.name.generator.respository;

import com.genodyme.name.generator.domain.FantasyLocationRequest;
import com.genodyme.name.generator.domain.FantasyLocationResponse;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FantasyLocationRepository extends CrudRepository<FantasyLocationRequest, Long> {
  FantasyLocationResponse findLocationByName(String name);
  FantasyLocationResponse findLocationById(UUID id);
}
