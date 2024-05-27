package com.mybatis.mapper;

import com.mybatis.bean.Department;
import com.mybatis.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * department部门表数据操作类
 */
public interface DepartmentMapper {

    /**
     * 根据id查询部门信息及部门下的所有员工-自定义映射
     * @return
     */
    Department  findDeptById(Integer id);

    /**
     * 关联查询一对多
     * @return
     */
    Department  findDeptById2(Integer id);

    /**
     * 根据id获取部门信息，为一对一分步查询做适配
     */
    @Select("SELECT id, name FROM departments WHERE id =#{ID}")
    Department getDeptById(Integer id);

    /**
     * 分步查询一对多
     * @return
     */
    Department  findDeptById3(Integer id);

    /**
     * 分步查询一对多-多个查询参数查询第二步
     * @return
     */
    Department  findDeptById4(Integer id);

}