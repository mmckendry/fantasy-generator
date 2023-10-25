package com.genodyme.name.generator.respository;

import com.genodyme.name.generator.domain.LocationRequest;
import com.genodyme.name.generator.domain.LocationResponse;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Location Repository for CRUD operations
 */
public interface LocationRepository extends CrudRepository<LocationRequest, Long> {

  LocationResponse findLocationByName(String name);

  LocationResponse findLocationById(UUID id);

}
