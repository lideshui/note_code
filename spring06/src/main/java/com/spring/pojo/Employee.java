package com.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 员工类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Employee {

    private String name;

}
