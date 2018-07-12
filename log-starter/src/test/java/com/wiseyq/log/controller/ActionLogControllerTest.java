package com.wiseyq.log.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.wiseyq.log.AppStarter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppStarter.class)
@WebAppConfiguration
public class ActionLogControllerTest {

    @Test
    public void testListRecord() {
        System.out.println("test");
    }
}
