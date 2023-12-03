package org.company.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="vehicle")
@Data
public class Vehicle {
    @Id
    @Column(name = "tabel_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tabelNumber;

    @Column(name="gos_num_sign",length = 6)
    private String gosNumSign;

    @Column(name="model",length = 25)
    private String model;

    @Column(name="vehicle_type",length = 12)
    private String vehicleType;

    @Column(name = "manufactured",length = 4)
    private String manufactured;



}
