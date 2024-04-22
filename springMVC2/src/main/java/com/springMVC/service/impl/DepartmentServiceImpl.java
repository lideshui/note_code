package com.springMVC.service.impl;

import com.springMVC.dao.DepartmentDao;
import com.springMVC.pojo.Department;
import com.springMVC.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Description: TODD
 * @AllClassName: com.atguigu.service.EmployeeService
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentDao departmentDao;

    //展示所有部门信息
    @Override
    public Collection<Department> showAllDept() {
        return departmentDao.getDepartments();
    }
}
