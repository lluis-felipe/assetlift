package com.assetlift.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "asset")
public class Asset {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "model")
    private String model;

    @Column(name = "acquisitiondate")
    private String acquisitiondate;

    @Column(name = "disposaldate")
    private String disposaldate;

    @Column(name = "location")
    private String location;

    @Column(name = "responsable")
    private String responsable;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "maintenanceschedule")
    private String maintenanceschedule;

    @Column(name = "usefullife")
    private String usefullife;

    @OneToMany(mappedBy = "asset", cascade = CascadeType.ALL)
    @Column(nullable = true)
    @JsonManagedReference
    private List<AssetHistory> history = new ArrayList<>();
}
