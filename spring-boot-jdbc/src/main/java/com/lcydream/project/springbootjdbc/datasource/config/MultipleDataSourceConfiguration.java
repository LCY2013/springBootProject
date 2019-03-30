package com.lcydream.project.springbootjdbc.datasource.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * MultipleDataSourceConfiguration
 * 多数据源配置
 * {@link DataSourceBuilder}
 * @author Luo Chun Yun
 * @date 2018/11/24 21:12
 */
@Configuration
public class MultipleDataSourceConfiguration {

	/**
	 * 配置主数据源
	 * @return 数据源
	 */
	@Bean
	@Primary
	public DataSource masterDataSource(){
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		DataSource dataSource = dataSourceBuilder
				.driverClassName("com.mysql.cj.jdbc.Driver")
				.url("jdbc:mysql://127.0.0.1:3306/spring_boot_database")
				.username("root")
				.password("123456")
				.build();
		return dataSource;
	}

	@Bean
	public DataSource slaveDataSource(){
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		DataSource dataSource = dataSourceBuilder
				.driverClassName("com.mysql.cj.jdbc.Driver")
				.url("jdbc:mysql://127.0.0.1:3306/spring_boot_database_one")
				.username("root")
				.password("123456")
				.build();
		return dataSource;
	}
}
