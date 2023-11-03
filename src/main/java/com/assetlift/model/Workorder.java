package com.assetlift.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "workorder")
public class Workorder {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "createddate")
    private String createddate;

    @Column(name = "duedate")
    private String duedate;

    @Column(name = "worktype")
    private String worktype;

    @Column(name = "estimatedcosts")
    private String estimatedcosts;

    @Column(name = "assignedto")
    private String assignedto;

    @JsonIgnore
    @OneToOne(targetEntity = Asset.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "asset_id", referencedColumnName = "id", updatable=false, insertable=false)
    private Asset asset;

    @Column(name="asset_id")
    private Long asset_id;
}
