package com.spring.service.impl;

import com.spring.dao.EmployeeDao;
import com.spring.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

        EmployeeDao employeeDao;

        public EmployeeServiceImpl() {
                System.out.println("EmployeeServiceImpl构造方法执行222");
        }

        public void setEmployeeDao(EmployeeDao employeeDao) {
                this.employeeDao = employeeDao;
                System.out.println("EmployeeServiceImpl的setEmployeeDao方法执行222");
        }

        @Override
        public void addEmployee() {
                employeeDao.insertEmp();
        }
}
