package com.mybatis.mapper;

import com.mybatis.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * employees员工表数据操作类
 */
public interface EmployeeMapper {

    /**
     * 新增员工信息
     * @param employee
     */
    @Insert({"<script>",
            "INSERT INTO employees VALUES(null,#{lastName},#{email},#{gender},#{salary},#{deptId})",
            "</script>"})
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(Employee employee);

    /**
     * 更新员工信息
     * @param employee
     */
    @Update("UPDATE employees SET last_name=#{lastName},email=#{email},gender=#{gender},salary=#{salary},dept_id=#{deptId} WHERE id=#{id}")
    void update(Employee employee);

    /**
     * 根据id删除员工信息
     * @param id
     */
    @Delete("DELETE FROM employees WHERE id=#{id}")
    void delete(Integer id);

    /**
     * 1. 查询多行返回bean对象集合
     * @return
     */
    List<Employee> findAll();


    /**
     * 2. 查询多行数据返回定制化Map集合
     * @return
     */
    @MapKey("id") //指定使用数据库中的那个字段的值作为map的key
    Map<Integer,Employee> findAllMap();

    /**
     * 3. 查询多行数据返回List嵌套Map集合
     * @return
     */
    List<Map<String,Object>> findAllList();

    /**
     * 1. 查询单行返回bean对象
     * @param id
     * @return
     */
    Employee getById(Integer id);

    /**
     * 2. 查询单行数据返回Map集合，数据库中的字段名为key，数据库中的字段值为value
     * @param id
     * @return
     */
    Map<String,Object> getByIdMap(Integer id );

    /**
     * 一对一级联查询，获取员工信息及所在部门详情
     * @param id
     * @return
     */
    Employee getByIdAsDept(Integer id);

    /**
     * 一对一关联查询，获取员工信息及所在部门详情
     * @param id
     * @return
     */
    Employee getByIdAsDept2(Integer id);

    /**
     * 分步查询一对一
     * @param id
     * @return
     */
    Employee getByIdAsDept3(Integer id);

    /**
     * 分步查询所需方法
     * @param id
     * @return
     */
    @Select(" select  id,last_name lastName,email,gender,salary,dept_id  from employees where dept_id=#{dept_id}")
    List<Employee> findAllByDeptId(Integer id);

    /**
     * 分步查询所需方法
     * @param id
     * @return
     */
    @Select(" select  id,last_name lastName,email,gender,salary,dept_id  from employees where dept_id=#{deptId} AND salary=#{salary}")
    List<Employee> findAllByDeptIdAndSalary(Integer id, double salary);
}