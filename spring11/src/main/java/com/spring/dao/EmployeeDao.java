package com.spring.dao;

import com.spring.pojo.Employee;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * employees员工表数据操作类
 */
public interface EmployeeDao {

    /**
     * 新增员工信息
     *
     * @param employee
     */
    @Insert({"<script>",
            "INSERT INTO employees VALUES(null,#{lastName},#{email},#{gender},#{salary},#{deptId})",
            "</script>"})
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(Employee employee);

    /**
     * 更新员工信息
     *
     * @param employee
     */
    @Update("UPDATE employees SET last_name=#{lastName},email=#{email},gender=#{gender},salary=#{salary},dept_id=#{deptId} WHERE id=#{id}")
    void update(Employee employee);

    /**
     * 根据id删除员工信息
     *
     * @param id
     */
    @Delete("DELETE FROM employees WHERE id=#{id}")
    void delete(Integer id);

    /**
     * 询多行返回bean对象集合
     *
     * @return
     */
    List<Employee> findAll();

    /**
     * 查询单行返回bean对象
     *
     * @param id
     * @return
     */
    Employee getById(Integer id);
}
