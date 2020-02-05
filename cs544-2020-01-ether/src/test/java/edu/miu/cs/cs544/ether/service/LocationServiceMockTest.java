package edu.miu.cs.cs544.ether.service;

import edu.miu.cs.cs544.ether.dal.entity.Location;
import edu.miu.cs.cs544.ether.dal.repository.LocationRepository;
import edu.miu.cs.cs544.ether.service.impl.LocationServiceImpl;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LocationServiceMockTest {

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private LocationService locationService = new LocationServiceImpl();

    List<Location> locations = Arrays.asList(new Location("ML1", "B1","McLaughlin", "18", 30 ),
            new Location("DR1", "B2","Drier", "10", 30 ));

    @Test
    void testGetLocations(){
        when(locationRepository.findAll()).thenReturn(locations);
        assertEquals(locationService.getLocations(), locations);
        verify(locationRepository).findAll();
    }

    @Test
    void testGetLocation() {
        when(locationRepository.findById(locations.get(0).getId())).thenReturn(Optional.of(locations.get(0)));
        assertEquals(locations.get(0), locationService.getLocationById(locations.get(0).getId()));
        verify(locationRepository).findById(locations.get(0).getId());
    }

    @Test
    void testAddLocation() {
        when(locationRepository.save(locations.get(1))).thenReturn(locations.get(1));
        assertEquals(locations.get(1), locationService.addLocation(locations.get(1)));
        verify(locationRepository).save(locations.get(1));
    }
}
