package com.rt.generalframework.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * TODO(mybatisplus配置项).
 *
 * <p>TODO(mybatisplus配置项).
 *
 *
 * @version V1.0
 * @since 2019/6/12 9:41
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.rt.generalframework.mapper")
public class MybatisPlusConfig {

}
