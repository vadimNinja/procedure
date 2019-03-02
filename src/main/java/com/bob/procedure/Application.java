package com.bob.procedure;

import com.bob.procedure.domain.Empl;
import com.bob.procedure.domain.Employees;
import com.bob.procedure.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private EmployeeDao employeeDao;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Empl> employeesList = employeeDao.getAllEmployees();
        System.out.println(employeesList.get(0).getId());
        System.out.println(employeesList.get(0).getAddress());
        System.out.println(employeesList.get(0).getFirstName());
        System.out.println(employeesList.get(0).getLastName());

    }
}
