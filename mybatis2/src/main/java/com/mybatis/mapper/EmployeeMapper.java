package com.mybatis.mapper;

import com.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

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
    void insert(Employee employee);

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

    /**
     * 查询单行数据返回Map集合，数据库中的字段名为key，数据库中的字段值为value
     * @param id
     * @return
     */
    Map<String,Object> getEmployeeByIdReturnMap(Integer id );


    /**
     * 查询多行数据返回Map集合
     * @return
     */
    @MapKey("id") //指定使用数据库中的那个字段的值作为map的key
    Map<Integer,Employee> getEmployeesReturnMap();

    /**
     * 查询多行数据返回List嵌套Map集合
     * @return
     */
    List<Map<String,Object>> getEmployeesReturnListMap();
}