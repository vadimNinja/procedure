package com.bob.procedure.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
@Data
//@NamedStoredProcedureQueries({
//        @NamedStoredProcedureQuery(
//                name = "getAllEmployees",
//                procedureName = "get_all_employees",
//                resultClasses = Employees.class
//        )
//})
public class Employees implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;

}
