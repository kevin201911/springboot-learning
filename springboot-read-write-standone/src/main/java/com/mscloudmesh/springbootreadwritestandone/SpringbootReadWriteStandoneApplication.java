package com.mscloudmesh.springbootreadwritestandone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mscloudmesh.springbootreadwritestandone.mapper")
@SpringBootApplication
public class SpringbootReadWriteStandoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootReadWriteStandoneApplication.class, args);
	}

}
