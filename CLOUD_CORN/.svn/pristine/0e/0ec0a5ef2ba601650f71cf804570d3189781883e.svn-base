package com.enc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

import com.enc.config.SolutionConfig;

@SpringBootApplication
@EnableConfigurationProperties(SolutionConfig.class)
public class Application {
    public static void main(String[] args) {
    	System.setProperty("spring.devtools.restart.enabled", "false"); 	// 배포시 반드시 false 처리 할 것
    	SpringApplication application 		= new SpringApplication(Application.class);
		// 배너 사용 여부
		//application.setBannerMode(org.springframework.boot.Banner.Mode.OFF);
		application.run(args);
    }
}
