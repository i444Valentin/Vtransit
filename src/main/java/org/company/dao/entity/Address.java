package org.company.dao.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "Address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "city", length = 16)
    private String city;

    @Column(name = "region", length = 30)
    private String region;

    @Column(name = "area", length = 20)
    private String area;

    @Column(name = "street", length = 15, nullable = false)
    private String street;

    @Column(name = "house", length = 5, nullable = false)
    private String house;

    @Column(name = "apartment", length = 3)
    private Integer apartment;

}
