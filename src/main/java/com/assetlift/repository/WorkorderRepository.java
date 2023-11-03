package com.assetlift.repository;

import com.assetlift.model.Workorder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkorderRepository extends JpaRepository<Workorder, Long> {
}
