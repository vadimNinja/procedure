package com.bob.procedure.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "getAllEmployees",
                procedureName = "get_all_employees",
                resultClasses = Empl.class
        )
})
public class Empl {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String address;

}
