package com.yangxf.demoRabbitMQ;

import com.yangxf.demoRabbitMQ.config.RabbitFanoutConfig;
import com.yangxf.demoRabbitMQ.config.RabbitTopicConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoRabbitMqApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;
	@Test
	void directTest() {
		rabbitTemplate.convertAndSend("hello-queue", "hello direct");
	}

	@Test
	void fanoutTest() {
		rabbitTemplate.convertAndSend(RabbitFanoutConfig.FANOUTCHANGE,null, "hello fanout");
	}
	@Test
	void topicTest() {
		rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"xiaomi.news", "小米新闻");
		rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"huawei.news", "华为新闻");
		rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"xiaomi.phone", "小米手机");
		rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"huawei.phone", "华为手机");
		rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"phone.news", "手机新闻");

	}

}
