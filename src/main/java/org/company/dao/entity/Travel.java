package org.company.dao.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="travel")
@Data
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer travelNumber;

    @ManyToOne
    @JoinColumn(name="vehicle", referencedColumnName = "tabel_number")
    private Vehicle vehicle;

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
