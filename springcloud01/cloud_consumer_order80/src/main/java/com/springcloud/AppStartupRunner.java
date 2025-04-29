package com.springcloud;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
@Order(1) // 确保在所有其他初始化完成后执行
class AppStartupRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(printAsciiArt());
    }

    private String printAsciiArt() {
        StringBuilder art = new StringBuilder();
        try (InputStream is = AppStartupRunner.class.getClassLoader().getResourceAsStream("little_prince_ascii.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            while ((line = reader.readLine()) != null) {
                art.append(line).append("\n");
            }
        } catch (Exception e) {
            art.append("无法加载 ASCII 艺术图案：").append(e.getMessage());
        }
        return art.toString();
    }
}