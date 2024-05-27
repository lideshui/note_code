package com.springMVC.service;

import com.springMVC.pojo.Employee;
import java.util.Collection;


public interface EmployeeService {
    //展示所有员工对象
    Collection<Employee> showAllEmp();

    //展示一个员工对象
    Employee showEmp(Integer id);

    //创建一个员工对象
    void createEmp(Employee employee);

    //基于ID删除一个员工对象
    void deleteEmp(Integer id);

    //修改员一个工对象
    void editEmp(Employee employee);
}
