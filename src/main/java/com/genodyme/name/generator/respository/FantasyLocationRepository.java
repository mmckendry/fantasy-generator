package com.genodyme.name.generator.respository;

import com.genodyme.name.generator.domain.FantasyLocationRequest;
import com.genodyme.name.generator.domain.FantasyLocationResponse;
import org.springframework.data.repository.CrudRepository;

public interface FantasyLocationRepository extends CrudRepository<FantasyLocationRequest, Long> {
  FantasyLocationResponse findFantasyLocationByName(String name);

}
