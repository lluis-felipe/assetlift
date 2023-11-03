package com.assetlift.service;

import com.assetlift.model.Workorder;
import com.assetlift.repository.WorkorderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkorderService {
    @Autowired
    private WorkorderRepository workorderRepository;

    public Workorder getWorkorder(Long id) {
        return workorderRepository.findById(id).orElse(null);
    }

    public List<Workorder> getWorkorders() {
        return workorderRepository.findAll();
    }

    public Workorder saveWorkorder(Workorder workorder) {
        return workorderRepository.save(workorder);
    }

    public Workorder updateWorkorder(Long id, Workorder workorderIn) {
        Workorder assetOut = workorderRepository.findById(id).orElse(null);
        if (assetOut == null) {
            return null;
        }
        workorderIn.setId(id);
        return workorderRepository.save(workorderIn);
    }

    public void deleteWorkorder(Long id) {
        workorderRepository.deleteById(id);
    }
}
