package com.hrf.demoTest;

import com.hrf.demo.damain.UserInfo;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;

@SpringBootTest
public class SpringBootDemoTest {
    @Test
    public void test01(){
        System.out.println("SpringBootTest status!");
    }

    @Test
    private void test02(){
        try {
            Field field = UserInfo.class.getField("userName");
            System.out.println(field.getType());
            UserInfo userInfo = UserInfo.class.newInstance();
            field.set(userInfo,"lv");
            System.out.println(field.get(userInfo));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
