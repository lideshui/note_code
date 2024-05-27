package com.springMVC.service;

import com.springMVC.pojo.Department;
import java.util.Collection;


public interface DepartmentService {

    //展示所有部门信息
    Collection<Department> showAllDept();

}
