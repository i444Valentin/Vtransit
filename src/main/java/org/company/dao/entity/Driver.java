package org.company.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Check;

import java.time.LocalDate;


@Entity
@Table(name = "driver")
@Data
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name",length = 25, nullable = false)
    private String firstName;

    @Column(name="last_name",length = 25, nullable = false)
    private String lastName;

    @Column(name = "surname",length = 30, nullable = false)
    private String surname;

    @Column(name = "birth_day")
    private LocalDate birthDate;

    @Column(name="gender",length = 10)
    @Check(constraints = "gender::text = 'мужской'::text OR gender::text = 'женский'::text")
    private String gender;



}
