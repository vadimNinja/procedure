package com.bob.procedure.repository;

import com.bob.procedure.domain.Employees;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employees, Long>, EmployeeRepositoryCustom {

    Employees findById(long id);

    @Procedure("getAllEmployees")
    List<Employees> getAllEmployees();

}
