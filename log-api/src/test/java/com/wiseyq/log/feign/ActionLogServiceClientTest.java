package com.wiseyq.log.feign;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ActionLogServiceClientTest.class)
@EnableFeignClients(clients = ActionLogServiceClient.class)
public class ActionLogServiceClientTest {
    @Test
    public void testListAction() {
        System.out.println("test run");
    }
}
