package org.company.dao.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "license")
@Data
public class License {

    @Id
    @Column(name = "serial_number")
    private Integer serialNumber;

    @Column(name="gibdd_number",unique = true,length = 4, nullable = false)
    private String gibddNumber;

    @Column(name="region",length = 20, nullable = false)
    private String region;

    @Column(name = "categories",length = 3, nullable = false)
    @Type(value = org.company.dao.custom_types.StringArrayType.class)
    private String[] categories;
}
