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

            // 测试动态sql  if where
            List<Employee> empList = employeeMapper.getEmp(2, null);
            System.out.println(empList);


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
