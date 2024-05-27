package com.spring.pojo;

import lombok.*;
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
