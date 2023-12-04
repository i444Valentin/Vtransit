package org.company.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Table(name = "payment")
@Data
public class Payment {

    @OneToOne
    @JoinColumn(name = "travel_number",referencedColumnName = "travel_number")
    @Id
    private Travel travelNumber;

    @Column(name = "time_count")
    private LocalTime timeCount;

    @Column(name = "travelled")
    private Integer travelled;

    @Column(name = "bonus")
    private Double bonus;

    @Column(name = "tariff_time")
    private Double tariffTime;

    @Column(name = "tariff_distance")
    private Double tariffDistance;

}
