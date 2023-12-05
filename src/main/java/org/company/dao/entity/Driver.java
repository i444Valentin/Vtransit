package org.company.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Check;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "driver")
@Data
@ToString(exclude = "travels")
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

    @OneToOne
    @JoinColumn(name="license", referencedColumnName = "serial_number")
    private License license;

    @OneToMany(mappedBy = "driver")
    private List<Travel> travels = new LinkedList<>();

}
