package org.company.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "route")
@Data
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer route_id;

    @ManyToOne
    @JoinColumn(name="departure",referencedColumnName = "id")
    private Address departure;

    @ManyToOne
    @JoinColumn(name="destination",referencedColumnName = "id")
    private Address destination;

    @Column(name="distance")
    private Integer distance;
}
