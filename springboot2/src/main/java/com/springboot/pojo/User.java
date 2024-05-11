package com.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

//标识当前是一个实体类⚠️
@Entity
//指定当前实体类对应的表的名称，名称若一样就不需要指定⚠️
@Table(name = "tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class User implements Serializable {
    //标识当前字段对应数据表的主键，删除或修改根据该属性来判定⚠️
    @Id
    private Integer id;
    //@Column(name = "name")，若列名和属性名一致可省略该注解，支持自动驼峰和下划线匹配⚠️
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String qq;
    private String email;
    private String username;
    private String phone;
}