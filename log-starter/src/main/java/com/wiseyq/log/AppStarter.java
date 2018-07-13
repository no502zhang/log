package com.wiseyq.log;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= {"com.wiseyq"})
@EnableFeignClients //使用Feign客户端，自带Ribbon负载均衡
@SpringCloudApplication
public class AppStarter {
	public static void main(String[] args) {
		SpringApplication.run(AppStarter.class, args);
	}
}
