package com.springaop.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.springaop.demo, com.springaop.demo.dao, com.springaop.demo.aspect, com.springaop.demo.service")
public class DemoConfig {

}
