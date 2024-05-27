package com.mybatis;

import com.mybatis.bean.Department;
import com.mybatis.bean.Employee;
import com.mybatis.mapper.DepartmentMapper;
import com.mybatis.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * mybatis测试类
 */
public class MybatisTest {

    @Test
    public void test01(){
        try {
            // 获取EmployeeMapper接口的实例对象，操作数据
            // 1. 获得到SqlSessionFactory对象
            // 1.1 指定核心配置文件的路径
            String resource = "mybatis-config.xml";
            // 1.2 根据配置文件的路径，获得到一个输入流
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 1.3 创建一个SqlSessionFactory的对象（设计模式中的工厂模式）
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 1.4 获得SqlSession对象(理解为Connection对象)
            SqlSession sqlSession = sqlSessionFactory.openSession();
            // 1.5 根据SqlSession对象获得到EmployeeDao对象
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);


            // 测试新增注解
//            Employee empMap = new Employee();
//            empMap.setLastName("TwoDogzj");
//            empMap.setEmail("123@666.com");
//            empMap.setGender(1);
//            empMap.setSalary(88888d);
//            empMap.setDeptId(2);
//            employeeMapper.insert(empMap);
//            System.out.println(empMap);

            // 测试修改注解
//            Employee editMap = new Employee();
//            editMap.setId(12);
//            editMap.setLastName("TwoDog222");
//            editMap.setEmail("123@666.com");
//            editMap.setGender(1);
//            editMap.setSalary(88888d);
//            editMap.setDeptId(2);
//            employeeMapper.update(editMap);

            // 测试删除注解
//           employeeMapper.delete(12);

            // 2. 测试增删查改
//            // 查询多行1
//            List<Employee> employeeList = employeeMapper.findAll();
//            employeeList.stream().forEach(System.out::println);
//
//            // 查询多行2
//            Map<Integer,Employee> maps = employeeMapper.findAllMap();
//            System.out.println("maps = " + maps);
//
//            // 查询多行3
//            List<Map<String,Object>> list = employeeMapper.findAllList();
//            System.out.println("list = " + list);
//
//            // 查询单行1
//            Employee byId = employeeMapper.getById(2);
//            System.out.println("byId = " + byId);
//
//            // 查询单行2
//            Map<String, Object> map = employeeMapper.getByIdMap(2);
//            System.out.println("map = " + map);
//
//            // 级联查询
//            Employee empAsDept = employeeMapper.getByIdAsDept(2);
//            System.out.println("级联查询empAsDept = " + empAsDept);
//
//            // 一对一关联查询
//            Employee empAsDept2 = employeeMapper.getByIdAsDept2(2);
//            System.out.println("一对一关联查询empAsDept2 = " + empAsDept2);

            // 一对一分步查询
            Employee empAsDept3 = employeeMapper.getByIdAsDept3(2);
            //System.out.println("一对一分步查询，查询一次 = " + empAsDept3.getLastName());
            System.out.println("一对一关联查询，查询两次 = " + empAsDept3);



            // 增删改是需要提交的，sqlSession对象去提交
            sqlSession.commit();
            // 其实配置文件中若没有对事务进行其他设置，默认也会关闭qlSession对象
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }


    @Test
    public void test02(){
        try {
            // 获取EmployeeMapper接口的实例对象，操作数据
            // 1. 获得到SqlSessionFactory对象
            // 1.1 指定核心配置文件的路径
            String resource = "mybatis-config.xml";
            // 1.2 根据配置文件的路径，获得到一个输入流
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 1.3 创建一个SqlSessionFactory的对象（设计模式中的工厂模式）
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 1.4 获得SqlSession对象(理解为Connection对象)
            SqlSession sqlSession = sqlSessionFactory.openSession();
            // 1.5 根据SqlSession对象获得到数据操作对象
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);


            // 测试手动映射
            Department dept= departmentMapper.findDeptById(2);
            System.out.println("测试手动映射 = " + dept);

            // 测试关联查询一对多
            Department dept2 = departmentMapper.findDeptById2(2);
            System.out.println("测试关联查询一对多 = " + dept2);

            // 测试关联查询一对多
            Department dept3 = departmentMapper.findDeptById3(2);
            //System.out.println("测试分步查询一对多，查询第一步 = " + dept3.getName());
            System.out.println("测试分步查询一对多，查询多步 = " + dept3.getEmpList());


            // 测试关联查询一对多
            Department dept4 = departmentMapper.findDeptById4(2);
            //System.out.println("测试分步查询一对多，查询第一步 = " + dept4.getName());
            System.out.println("测试分步查询一对多，查询多步 = " + dept4.getEmpList());



            // 增删改是需要提交的，sqlSession对象去提交
            sqlSession.commit();
            // 其实配置文件中若没有对事务进行其他设置，默认也会关闭qlSession对象
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
