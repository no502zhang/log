package com.wiseyq.log.feign;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wiseyq.log.AppStarter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppStarter.class)
public class ActionLogServiceClientTest {
    @Test
    public void testListAction() {
        System.out.println("test run");
    }
}
