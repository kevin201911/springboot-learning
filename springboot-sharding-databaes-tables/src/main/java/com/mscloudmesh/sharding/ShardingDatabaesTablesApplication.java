package com.mscloudmesh.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mscloudmesh.sharding.mapper")
@SpringBootApplication
public class ShardingDatabaesTablesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingDatabaesTablesApplication.class, args);
	}

}
