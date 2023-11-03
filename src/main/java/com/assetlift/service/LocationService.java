package com.assetlift.service;

import com.assetlift.model.Location;
import com.assetlift.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public Location getLocation(Long id) {
        return locationRepository.findById(id).orElse(null);
    }

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location updateLocation(Long id, Location locationIn) {
        Location locationOut = locationRepository.findById(id).orElse(null);

        if (locationOut == null) {
            return null;
        }

        locationIn.setId(id);
        return locationRepository.save(locationIn);
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
