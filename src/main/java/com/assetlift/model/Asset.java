package com.assetlift.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "asset")
public class Asset {
    @Id
    @GeneratedValue
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
}
