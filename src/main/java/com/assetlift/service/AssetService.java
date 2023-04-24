package com.assetlift.service;

import com.assetlift.model.Asset;
import com.assetlift.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;

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
        return assetRepository.save(assetIn);
    }

    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }
}
