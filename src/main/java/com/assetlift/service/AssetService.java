package com.assetlift.service;

import com.assetlift.model.Asset;
import com.assetlift.model.AssetHistory;
import com.assetlift.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private AssetHistoryService assetHistoryService;

    public Asset getAsset(Long id) {
        return assetRepository.findById(id).orElse(null);
    }

    public List<Asset> getAssets() {
        return assetRepository.findAll();
    }

    public Asset saveAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public Asset updateAsset(Long id, Asset assetIn) {
        Asset assetOut = assetRepository.findById(id).orElse(null);
        if (assetOut == null) {
            return null;
        }
        assetIn.setId(id);
        if (!assetIn.getStatus().equals(assetOut.getStatus())) {
            var assetHistory = assetHistoryService.saveAssetHistory(
                    new AssetHistory(assetIn, new Date().toString(), assetOut.getStatus()));
            assetIn.getHistory().add(assetHistory);

        }
        return assetRepository.save(assetIn);
    }

    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }
}
