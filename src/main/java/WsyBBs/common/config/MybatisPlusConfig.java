package WsyBBs.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;

@Configuration
public class MybatisPlusConfig {
	
	/**
	 *逻辑删除 
	 * 
	 **/
	@Bean
	public LogicSqlInjector logicSqlInjector() {
		return new LogicSqlInjector();		
	}
	
	/**
	 *分页插件 
	 * 
	 **/
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}
}
