package org.company.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "vehicle")
@Data
public class Vehicle {
    @Id
    @PrimaryKeyJoinColumn(name = "tabel_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(cascade = CascadeType.ALL)
    private Servicing servicing;

    @Column(name = "gos_num_sign", length = 6, nullable = false)
    private String gosNumSign;

    @Column(name = "model", length = 25, nullable = false)
    private String model;

    @Column(name = "vehicle_type", length = 12, nullable = false)
    private String vehicleType;

    @Column(name = "manufactured", length = 4, nullable = false)
    private String manufactured;

    @OneToMany(mappedBy = "vehicle",cascade = CascadeType.PERSIST)
    private List<Travel> travels = new LinkedList<>();
}
