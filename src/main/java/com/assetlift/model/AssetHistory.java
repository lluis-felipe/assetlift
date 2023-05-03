package com.assetlift.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "asset_history")
public class AssetHistory {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id", referencedColumnName = "id")
    @JsonBackReference
    private Asset asset;

    @Column(name = "date_time")
    private String dateTime;

    @Column(name = "status")
    private String status;

    public AssetHistory(Asset assetIn, String dateTimeIn, String statusIn) {
        this.asset = assetIn;
        this.dateTime = dateTimeIn;
        this.status = statusIn;
    }
}
