package com.spring.service.impl;

import com.spring.dao.EmployeeDao;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EmployeeDao employeeDao;



}