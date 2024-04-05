package com.lds;


import com.lds.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author chenxin
 * @date 2022/10/29
 * @Version 1.0
 */
public class MybatisTest {
    @Test
    public void test01(){
        try {
            //最终目标是获得到EmployeeDao的对象
            //后期所有dao的对象都交给Spring管理
            //1. 获得到SqlSessionFactory对象
            //1.1 指定核心配置文件的路径
            String resource = "mybatis-config.xml";
            //1.2 根据配置文件的路径，获得到一个输入流
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //1.3 创建一个SqlSessionFactory的对象（设计模式中的工厂模式）
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //1.4 获得SqlSession对象(理解为Connection对象)
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //1.5 根据SqlSession对象获得到EmployeeDao对象
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);

//            List<Employee> employeeList = employeeDao.findAll();

            //遍历list集合
//            employeeList.stream().forEach(System.out::println);

           /* Employee byId = employeeDao.getById(6);
            System.out.println("byId = " + byId);*/

            /*byId.setLastName("makesi");
            employeeDao.insert(byId);*/

           /* byId.setEmail("makesi@atguigu.com");
            employeeDao.update(byId);*/

            employeeDao.delete(3);

            //增删改是需要提交的，sqlSession对象去提交
            sqlSession.commit();



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
