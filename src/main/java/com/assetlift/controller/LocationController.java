package com.assetlift.controller;

import com.assetlift.model.Location;
import com.assetlift.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/assetlift/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable Long id) {
        var location = locationService.getLocation(id);
        if (location != null) {
            return ResponseEntity.ok(location);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Location> getLocations() {
        return locationService.getLocations();
    }

    @PostMapping
    public ResponseEntity<Location> saveLocation(@RequestBody Location locationIn) throws URISyntaxException {
        var locationOut = locationService.saveLocation(locationIn);
        return ResponseEntity.created(new URI("/locations/" + locationOut.getId())).body(locationOut);
    }

    @PostMapping("onboarding")
    @ResponseStatus(HttpStatus.OK)
    public List<Location> saveLocations(@RequestBody List<Location> locationsIn) throws URISyntaxException {
        for (Location locationIn : locationsIn) {
            locationService.saveLocation(locationIn);
        }
        return locationsIn;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location locationIn) throws URISyntaxException {
        var locationOut = locationService.updateLocation(id, locationIn);
        if (locationOut != null) {
            return ResponseEntity.noContent().build();
        }
        return saveLocation(locationIn);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Location> deleteLocation(@PathVariable Long id) {
        var location = locationService.getLocation(id);
        if (location != null) {
            locationService.deleteLocation(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
