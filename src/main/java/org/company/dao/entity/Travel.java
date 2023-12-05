package org.company.dao.entity;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="travel")
@Data
public class Travel {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @MapsId
//    private Integer travelNumber;
    @Id
    @Nonnull
    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    @ManyToOne
    @JoinColumn(name="vehicle", referencedColumnName = "tabel_number")
    private Vehicle vehicle;

//    @OneToOne(mappedBy = "travel",cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private Payment payment;

    @ManyToOne
    @JoinColumn(name="driver", referencedColumnName = "id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name="route", referencedColumnName = "route_id")
    private Route route;

    @Column(name="task_description")
    private String taskDescription;

    @Column(name = "started")
    private LocalTime started;

    @Column(name = "finished")
    private LocalTime finished;

    @Column(name = "travel_date")
    private LocalDate travelDate;
}
