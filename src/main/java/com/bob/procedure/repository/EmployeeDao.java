package com.bob.procedure.repository;

import com.bob.procedure.domain.Empl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Repository
@Transactional
public class EmployeeDao {

    @PersistenceContext
    private EntityManager em;

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public List<Employees> getAllArticles() {
//        String sql = "SELECT articleId, title, category FROM articles";
//        RowMapper<Article> rowMapper = new ArticleRowMapper();
//        return this.jdbcTemplate.query(sql, rowMapper);
//    }


//    public List<Employees> getAllEmployees() {
//        String sql = "SELECT id, first_name, last_name, address FROM employees";
//        RowMapper<Employees> rowMapper = new BeanPropertyRowMapper<>(Employees.class);
//        return this.jdbcTemplate.query(sql, rowMapper);
//    }

//    public List<Employees> getAllEmployees() {
//        return jdbcTemplate.query(
//                "SELECT id, first_name, last_name, address FROM employees",
//                (rs, rowNum) -> new Employees(
//                        rs.getLong("id"),
//                        rs.getString("first_name"),
//                        rs.getString("last_name"),
//                        rs.getString("address")
//                        )
//                );
//    }

//    public List<Empl> getAllEmployees() {
//
//
//        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("get_all_employees").withReturnValue();
//        SqlParameterSource in = new EmptySqlParameterSource();
//
//
////        Map list = jdbcCall.execute(in);
//        Map list = jdbcCall.execute(in);
//        return new ArrayList<>();
//    }

//    public List<Empl> getAllEmployees() {
//        MyStoredProcedure myStoredProcedure = new MyStoredProcedure(jdbcTemplate, "get_all_employees");
//        myStoredProcedure.compile();
//        Map<String, Object> storedProcResult = myStoredProcedure.execute();
//
//        Object[] targetList = storedProcResult.values().toArray();
//
//
//        List<Empl> empls = new ArrayList<>();
//        for (Object o : targetList) {
//            System.out.println(o);
//        }
//
//
////        ArrayList<Object> targetList = new ArrayList<>(storedProcResult.values());
//
//
////        List<Employees> list;
////
////
////        int index = 0;
////        for (Map.Entry<String, Object> mapEntry : storedProcResult.entrySet()) {
////
////
////
////            System.out.println(mapEntry.getValue());
//////            values[index] = mapEntry.getValue();
//////            index++;
////        }
//
//
//        return new ArrayList<>();
//    }

    public List<Empl> getAllEmployees() {
//        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("get_all_employees", Empl.class);
        StoredProcedureQuery storedProcedure = em.createNamedStoredProcedureQuery("getAllEmployees");
        storedProcedure.execute();
        List<Empl> empls = new ArrayList<>();
        for(Object o : storedProcedure.getResultList()) {
            empls.add((Empl) o);
        }

        return empls;
    }


}
