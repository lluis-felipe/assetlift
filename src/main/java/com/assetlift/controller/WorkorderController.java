package com.assetlift.controller;

import com.assetlift.model.Workorder;
import com.assetlift.service.WorkorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/assetlift/workorder")
public class WorkorderController {
    @Autowired
    private WorkorderService workorderService;

    @GetMapping("/{id}")
    public ResponseEntity<Workorder> getWorkorder(@PathVariable Long id) {
        var workorder = workorderService.getWorkorder(id);
        if (workorder != null) {
            return ResponseEntity.ok(workorder);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Workorder> getWorkorders() {
        return workorderService.getWorkorders();
    }

    @PostMapping
    public ResponseEntity<Workorder> saveAsset(@RequestBody Workorder workorderIn) throws URISyntaxException {
        var workorderOut = workorderService.saveWorkorder(workorderIn);
        return ResponseEntity.created(new URI("/workorders/" + workorderOut.getId())).body(workorderOut);
    }

    @PostMapping("onboarding")
    @ResponseStatus(HttpStatus.OK)
    public List<Workorder> saveWorkorders(@RequestBody List<Workorder> workordersIn) throws URISyntaxException {
        for (Workorder workorderIn : workordersIn) {
            workorderService.saveWorkorder(workorderIn);
        }
        return workordersIn;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workorder> updateAsset(@PathVariable Long id, @RequestBody Workorder workorderIn) throws URISyntaxException {
        var workorderOut = workorderService.updateWorkorder(id, workorderIn);
        if (workorderOut != null) {
            return ResponseEntity.noContent().build();
        }
        return saveAsset(workorderIn);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Workorder> deleteAsset(@PathVariable Long id) {
        var workorder = workorderService.getWorkorder(id);
        if (workorder != null) {
            workorderService.deleteWorkorder(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
