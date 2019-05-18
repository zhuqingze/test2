package com.example.demo;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={DemoApplication.class})// 指定启动类
//@SpringApplicationConfiguration(classes = Application.class)// 1.4.0 前版本
public class ApplicationTests {
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testOne(){
        Person person=new Person();
        person.setAge(4);
        person.setName("tome");
        personRepository.save(person);
    }

    @Before
    public void testBefore(){
        System.out.println("before");
    }

    @After
    public void testAfter(){
        System.out.println("after");
    }
}