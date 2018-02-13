package com.example.demo;

import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
@EnableJms
public class ActivemqApplication {

	@Bean
	public JmsListenerContainerFactory<?> myfactory(ConnectionFactory connectionFactory , DefaultJmsListenerContainerFactoryConfigurer configure){
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configure.configure(factory, connectionFactory);
		
		return factory;
	}
	@Bean
	public MessageConverter jacksonMsgConv(){
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
	public static void main(String[] args) {
		ConfigurableApplicationContext context  =  SpringApplication.run(ActivemqApplication.class, args);
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		System.out.println("Sending Email Service");
		jmsTemplate.convertAndSend("mailbox",new Email("info@info.com", "Hello"));
		jmsTemplate.convertAndSend("DbChecks",new Email("db@dvb.com", "HelloDataBase"));
	}
}
