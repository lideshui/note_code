package test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


//指定这是一个Spring Boot的测试类, 运行时会自动加载Spring Boot运行环境
@SpringBootTest
public class TestJedis {

    @Test
    public void test(){
        System.out.println(123);
    }
}
