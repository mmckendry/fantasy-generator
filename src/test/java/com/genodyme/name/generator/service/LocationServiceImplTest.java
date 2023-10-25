package com.genodyme.name.generator.service;


import com.genodyme.name.generator.domain.LocationResponse;
import com.genodyme.name.generator.respository.LocationRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class LocationServiceImplTest {

  @Mock
  LocationRepository repository;
  @InjectMocks
  LocationServiceImpl fantasyLocationService;

  @Test
  void generateLocationTest() {

    when(repository.save(any())).thenReturn(new LocationResponse(null,"town", null, null));
    when(repository.findLocationByName(anyString())).thenReturn(new LocationResponse(null,"town", null, null));
    LocationResponse testResponse = fantasyLocationService.generateLocation();

    assertNotNull(testResponse);
    assertEquals("town", testResponse.getName());
  }
}