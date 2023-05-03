package com.assetlift.repository;

import com.assetlift.model.AssetHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetHistoryRepository extends JpaRepository<AssetHistory, Long> {
}
