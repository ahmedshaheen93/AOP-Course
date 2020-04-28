package com.shaheen.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Component
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.shaheen")
public class AppConfig {

}
