package com.bob.procedure.repository;

import com.bob.procedure.domain.Empl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

public class MyStoredProcedure extends StoredProcedure {

    public MyStoredProcedure(JdbcTemplate jdbcTemplate, String name) {

        super(jdbcTemplate, name);
        setFunction(false);

    }

}
