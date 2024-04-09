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
     * 测试动态sql  if where
     * @return
     */
    List<Employee> getEmp1(Integer dept_id, Integer gender);

    /**
     * 测试动态sql  trim
     * @return
     */
    List<Employee> getEmp2(Integer dept_id, Integer gender);

    /**
     * 测试动态sql  choose(when,otherwise)
     * @return
     */
    List<Employee> getEmp3(Integer dept_id, Integer gender, Double salary);

    /**
     * 测试动态sql  set
     * @param map
     * @return
     */
    Boolean updateEmp(Map map);

    /**
     * 测试动态sql  foreach  批量删除IN
     * @return
     */
    Integer deleteByIds(Integer[] ids);

    /**
     * 测试动态sql  foreach  批量删除OR
     * @return
     */
    Integer deleteByIdsOr(Integer[] ids);


    /**
     * 测试动态sql  foreach  批量插入
     * @return
     */
    Integer insertMany(List list);

}