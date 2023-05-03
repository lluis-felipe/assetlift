package com.assetlift.service;

import com.assetlift.model.AssetHistory;
import com.assetlift.repository.AssetHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetHistoryService {
    @Autowired
    private AssetHistoryRepository assetHistoryRepository;

    public AssetHistory getAssetHistory(Long id) {
        return assetHistoryRepository.findById(id).orElse(null);
    }

    public List<AssetHistory> getAssetHistories() {
        return assetHistoryRepository.findAll();
    }

    public AssetHistory saveAssetHistory(AssetHistory assetHistory) {
        return assetHistoryRepository.save(assetHistory);
    }

    public AssetHistory updateAssetHistory(Long id, AssetHistory assetHistoryIn) {
        var assetHistoryOut = assetHistoryRepository.findById(id).orElse(null);
        if (assetHistoryOut == null) {
            return null;
        }
        assetHistoryIn.setId(id);
        return assetHistoryRepository.save(assetHistoryIn);
    }

    public void deleteAssetHistory(Long id) {
        assetHistoryRepository.deleteById(id);
    }
}
