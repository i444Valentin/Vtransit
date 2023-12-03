package org.company.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Table(name = "license")
@Data
public class License {

    @Id
    @Column(name = "serial_number")
    private Integer serialNumber;

    @Column(name="gibdd_number",unique = true,length = 4)
    private String gibddNumber;

    @Column(name="region",length = 20)
    private String region;

    @Column(name = "categories",length = 3)
    @Type(value = org.company.entity.custom_types.StringArrayType.class)
    private String[] categories;


}
