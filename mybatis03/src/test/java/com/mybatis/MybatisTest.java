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
import java.util.*;

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

            // 测试动态sql   if where
            List<Employee> empList1 = employeeMapper.getEmp1(2, null);
            System.out.println("测试动态sql  if where = " + empList1);



            // 测试动态sql  trim
            List<Employee> empList2 = employeeMapper.getEmp2(2, null);
            System.out.println("测试动态sql  trim = " + empList2);

//            // 测试动态sql  choose(when,otherwise)
//            List<Employee> empList3 = employeeMapper.getEmp3(null, null, 88888.0);
//            System.out.println("测试动态sql  choose(when,otherwise) = " + empList3);

//            // 测试动态sql  set
//            HashMap<Object, Object> updateMap = new HashMap<>();
//            updateMap.put("id", "2");
//            updateMap.put("lastName", "222");
//            boolean updateFlag = employeeMapper.updateEmp(updateMap);
//            System.out.println("修改标识 = " + updateFlag);

//            // 测试动态sql  foreach  批量删除-IN
//            Integer[] ids = {13, 14, 15};
//            Integer delNum1 = employeeMapper.deleteByIds(ids);
//            System.out.println("测试动态sql  foreach  批量删除-IN = " + delNum1);

//            // 测试动态sql  foreach  批量删除-OR
//            Integer[] ids2 = {16, 17, 333};
//            Integer delNum2 = employeeMapper.deleteByIdsOr(ids2);
//            System.out.println("测试动态sql  foreach  批量删除-OR = " + delNum2);

//            // 测试动态sql  foreach  批量插入
//            Employee employee1 = new Employee(null,"small7", "123@.com", 0, 77777.0, 3, null);
//            Employee employee2 = new Employee(null,"small8", "123@.com", 0, 77777.0, 3, null);
//            Employee employee3 = new Employee(null,"small9", "123@.com", 0, 77777.0, 3, null);
//            List list = new ArrayList();
//            list.add(employee1);
//            list.add(employee2);
//            list.add(employee3);
//            employeeMapper.insertMany(list);


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
            SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            //根据同一个SqlSessionFactory对象获取两个不同的连接对象
            SqlSession sqlSession1 = factory.openSession();
            SqlSession sqlSession2 = factory.openSession();

            //根据不同连接对象获取mapper对象
            EmployeeMapper mapper1 = sqlSession1.getMapper(EmployeeMapper.class);
            EmployeeMapper mapper2 = sqlSession2.getMapper(EmployeeMapper.class);
            EmployeeMapper mapper3 = sqlSession2.getMapper(EmployeeMapper.class);
            EmployeeMapper mapper4 = sqlSession2.getMapper(EmployeeMapper.class);
            EmployeeMapper mapper5 = sqlSession2.getMapper(EmployeeMapper.class);
            System.out.println(mapper1.getEmp1(2, null));
            //执行完第一个select语句之后，已经存到sqlSession1的一级缓存之中了
            //现在执行commit()或close()方法⚠️
            //将sqlSession1的一级缓存中存到二级缓存SqlSessionFactory中
            //查询了两次，最终却只执行了一次查询操作
            sqlSession1.commit();
            System.out.println(mapper2.getEmp1(2, null));
            System.out.println(mapper3.getEmp1(2, null));
            System.out.println(mapper4.getEmp1(2, null));
            System.out.println(mapper5.getEmp1(2, null));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
