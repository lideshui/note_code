package com.spring.dao;

import com.spring.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(Employee employee){
        String sql = "insert into employees(id, last_name, email, gender, salary, dept_id) values(?, ?, ?, ?, ?, ?)";
        int count = jdbcTemplate.update(
                sql,
                null,
                employee.getLastName(),
                employee.getEmail(),
                employee.getGender(),
                employee.getSalary(),
                employee.getDeptId());
        System.out.println("数据插入成功，记录条数：" + count);
    }

    public void delete(Integer id){
        String sql = "delete from employees where id = ?";
        int count = jdbcTemplate.update(sql, id);
        System.out.println("数据删除成功，记录条数：" + count);
    }

    public List<Employee> select(){
        String sql = "select id, last_name, email, gender, salary, dept_id from employees";
        //结果集处理器 , 相当于ResultSetHandler
        //ResultSetHandler : 需要手动循环结果集中每一个结果 , while(resultSet.next)
        //RowMapper : 不需要手动循环 , 可以直接处理结果集中的每一个结果
        List<Employee> employeeList = jdbcTemplate.query(
                sql,
                new RowMapper<Employee>() {
                    public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                        Employee employee = new Employee(
                                resultSet.getInt("id"),
                                resultSet.getString("last_name"),
                                resultSet.getString("email"),
                                resultSet.getInt("gender"),
                                resultSet.getDouble("salary"),
                                resultSet.getInt("dept_id")
                        );
                        return employee;
                    }
                }
        );
        return employeeList;
    }

    public void update(Employee employee){
        String sql = "update employees set last_name = ? where id = ?";
        int count = jdbcTemplate.update(
                sql,
                employee.getLastName(),
                employee.getId());
        System.out.println("数据修改成功，修改条数：" + count);
    }
}
