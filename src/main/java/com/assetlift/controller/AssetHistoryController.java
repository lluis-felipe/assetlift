package com.assetlift.controller;

import com.assetlift.model.AssetHistory;
import com.assetlift.service.AssetHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/assetlift/assethistory")
public class AssetHistoryController {

    @Autowired
    private AssetHistoryService assetHistoryService;

    @GetMapping("/{id}")
    public ResponseEntity<AssetHistory> getAssetHistory(@PathVariable Long id) {
        var assetHistory = assetHistoryService.getAssetHistory(id);
        if (assetHistory != null) {
            return ResponseEntity.ok(assetHistory);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<AssetHistory> getAssetHistories() {
        return assetHistoryService.getAssetHistories();
    }

    @PostMapping
    public ResponseEntity<AssetHistory> saveAssetHistory(@RequestBody AssetHistory assetIn) throws URISyntaxException {
        var assetHistoryOut = assetHistoryService.saveAssetHistory(assetIn);
        return ResponseEntity.created(new URI("/assets/" + assetHistoryOut.getId())).body(assetHistoryOut);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssetHistory> updateAssetHistory(@PathVariable Long id, @RequestBody AssetHistory assetHistoryIn) throws URISyntaxException {
        var assetHistoryOut = assetHistoryService.updateAssetHistory(id, assetHistoryIn);
        if (assetHistoryOut != null) {
            return ResponseEntity.noContent().build();
        }
        return saveAssetHistory(assetHistoryIn);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AssetHistory> deleteAssetHistory(@PathVariable Long id) {
        var assetHistory = assetHistoryService.getAssetHistory(id);
        if (assetHistory != null) {
            assetHistoryService.deleteAssetHistory(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
