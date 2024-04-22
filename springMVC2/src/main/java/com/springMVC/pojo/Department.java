package com.springMVC.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * 部门表映射类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Department {
    private Integer id;
    private String name;
}