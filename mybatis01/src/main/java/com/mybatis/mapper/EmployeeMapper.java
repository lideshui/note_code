package com.mybatis.mapper;

import com.mybatis.bean.Employee;
import java.util.List;

/**
 * employee员工表数据操作类
 */
public interface EmployeeMapper {

    /**
     * 查询员工列表
     * @return
     */
    List<Employee> findAll();

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    Employee getById(Integer id);

    /**
     * 新增员工信息
     * @param employee
     */
    void  insert(Employee employee);

    /**
     * 更新员工信息
     * @param employee
     */
    void update(Employee employee);

    /**
     * 根据id删除员工信息
     * @param id
     */
    void delete(Integer id);
}