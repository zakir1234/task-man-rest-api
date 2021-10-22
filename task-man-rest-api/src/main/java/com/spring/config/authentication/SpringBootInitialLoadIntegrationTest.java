package com.spring.config.authentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.jdbc.Sql;

@Configuration
@Sql({"/sql/schema.sql", "/sql/data.sql"})
public class SpringBootInitialLoadIntegrationTest {



}