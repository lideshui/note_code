package com.springMVC.service;

import com.springMVC.pojo.Department;
import java.util.Collection;

/**
 * @Description: TODD
 * @AllClassName: com.atguigu.service.DepartmentService
 */
public interface DepartmentService {

    //展示所有部门信息
    Collection<Department> showAllDept();

}
