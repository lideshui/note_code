package com.springMVC.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 员工表映射类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Double salary;
    private Department department;
}



