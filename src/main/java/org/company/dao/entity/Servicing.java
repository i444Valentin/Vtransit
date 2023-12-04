package org.company.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Check;

import java.time.LocalDate;

@Entity
@Table(name = "servicing")
@Data
public class Servicing {
    @Id
    @Column(name = "tabel_number")
    private Integer tabel_number;

    @Column(name = "traveled", nullable = false)
    private Integer traveled;

    @Column(name = "engine_state", length = 20, nullable = false)
    @Check(constraints = "engine_state::text = 'Исправен'::text " +
            "OR engine_state::text = 'Необходимо обслужить'::text " +
            "OR engine_state::text = 'Неисправен'::text")
    private String engineState;

    @Column(name = "transmission_state", length = 20, nullable = false)
    @Check(constraints = "engine_state::text = 'Исправна'::text " +
            "OR engine_state::text = 'Необходимо обслужить'::text " +
            "OR engine_state::text = 'Неисправна'::text")
    private String transmissionState;

    @Column(name = "common_state", length = 20, nullable = false)
    @Check(constraints = "engine_state::text = 'Исправен'::text " +
            "OR engine_state::text = 'Необходимо обслужить'::text " +
            "OR engine_state::text = 'Неисправен'::text")
    private String commonState;

    @Column(name = "last_service", nullable = false)
    private LocalDate lastService;
}
