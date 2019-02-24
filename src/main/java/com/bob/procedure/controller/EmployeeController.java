package com.bob.procedure.controller;

import com.bob.procedure.domain.Employees;
import com.bob.procedure.repository.EmployeeRepository;
import com.bob.procedure.repository.EmployeeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final EmployeeRepositoryImpl repository;

    //Получение данных с помощью процедуры
    //Второй разработчик внес изменения
    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, EmployeeRepositoryImpl repository) {
        this.employeeRepository = employeeRepository;
        this.repository = repository;
    }

//    @GetMapping("/")
//    public ResponseEntity<List<Employees>> getAllEmployees() {
//        List<Employees> employees = repository.getAllEmployees();
//        return new ResponseEntity<>(employees, HttpStatus.OK);
//    }

    @GetMapping("/")
    public ResponseEntity<List<Employees>> getAllEmployees() {
        List<Employees> employees = employeeRepository.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employees> getAllEmployeeById(@PathVariable(name = "id") long id) {
        Employees one = employeeRepository.findById(id);
        return new ResponseEntity<>(one, HttpStatus.OK);
    }

}
