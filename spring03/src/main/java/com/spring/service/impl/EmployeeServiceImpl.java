package com.spring.service.impl;

import com.spring.dao.EmployeeDao;
import com.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

        @Autowired
        EmployeeDao employeeDao;

        @Override
        public void addEmployee() {
                employeeDao.insertEmp();
        }
}
