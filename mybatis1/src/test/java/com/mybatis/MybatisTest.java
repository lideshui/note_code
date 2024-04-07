package com.mybatis;

import com.mybatis.bean.Employee;
import com.mybatis.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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

            // 2. 测试增删查改
            // 获取list集合
            List<Employee> employeeList = employeeMapper.findAll();
            employeeList.stream().forEach(System.out::println);

            // 根据id获取详情
//            Employee byId = employeeMapper.getById(2);
//            System.out.println("byId = " + byId);

            // 新增实例对象
//            Employee empMap = new Employee();
//            empMap.setLastName("TwoDog");
//            empMap.setEmail("123@666.com");
//            empMap.setGender(1);
//            empMap.setSalary(88888d);
//            empMap.setDeptId(2);
//            employeeMapper.insert(empMap);
//            System.out.println(empMap);

            // 修改实例对象
//            Employee editMap = new Employee();
//            editMap.setId(10);
//            editMap.setLastName("TwoDog222");
//            editMap.setEmail("123@666.com");
//            editMap.setGender(1);
//            editMap.setSalary(88888d);
//            editMap.setDeptId(2);
//            employeeMapper.update(editMap);

            // 删除实例对象
//            employeeMapper.delete(10);

            //增删改是需要提交的，sqlSession对象去提交
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
