package org.company.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "payment")
@Data
@Accessors(chain = true)
@ToString(exclude = "travel")
public class Payment {

    @Id
    @Column(name="travel_number")
    private Integer travelNumber;

    @OneToOne
    @MapsId
    @JoinColumn(name= "travel_number")
    private Travel travel;

    @Column(name = "time_count")
    private LocalTime timeCount;

    @Column(name = "travelled")
    private Integer travelled;

    @Column(name = "bonus")
    private BigDecimal bonus;

    @Column(name = "tariff_time")
    private BigDecimal tariffTime;

    @Column(name = "tariff_distance")
    private BigDecimal tariffDistance;

}
