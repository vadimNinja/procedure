package com.bob.procedure.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employees")
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "getAllEmployees",
                procedureName = "get_all_employees",
                resultClasses = Employees.class
        )
})
public class Employees implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "address")
    private String address;

}
