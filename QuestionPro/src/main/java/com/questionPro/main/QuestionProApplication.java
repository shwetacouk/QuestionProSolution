package com.questionPro.main;

import com.questionPro.controller.ArticleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@EnableCaching(proxyTargetClass = true)
@ComponentScan(basePackageClasses = ArticleController.class)
public class QuestionProApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionProApplication.class, args);
	}

}
