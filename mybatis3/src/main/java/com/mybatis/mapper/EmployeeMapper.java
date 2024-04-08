package com.mybatis.mapper;

import com.mybatis.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * employees员工表数据操作类
 */
public interface EmployeeMapper {

    List<Employee> getEmp(Integer dept_id, Integer gender);
}