package com.assetlift.controller;

import com.assetlift.model.Asset;
import com.assetlift.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/assetlift/asset")
public class AssetController {
    @Autowired
    private AssetService assetService;

    @GetMapping("/{id}")
    public ResponseEntity<Asset> getAsset(@PathVariable Long id) {
        var asset = assetService.getAsset(id);
        if (asset != null) {
            return ResponseEntity.ok(asset);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Asset> getAssets() {
        return assetService.getAssets();
    }

    @PostMapping
    public ResponseEntity<Asset> saveAsset(@RequestBody Asset assetIn) throws URISyntaxException {
        var assetOut = assetService.saveAsset(assetIn);
        return ResponseEntity.created(new URI("/assets/" + assetOut.getId())).body(assetOut);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asset> updateAsset(@PathVariable Long id, @RequestBody Asset assetIn) throws URISyntaxException {
        var assetOut = assetService.updateAsset(id, assetIn);
        if (assetOut != null) {
            return ResponseEntity.noContent().build();
        }
        return saveAsset(assetIn);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Asset> deleteAsset(@PathVariable Long id) {
        var asset = assetService.getAsset(id);
        if (asset != null) {
            assetService.deleteAsset(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
