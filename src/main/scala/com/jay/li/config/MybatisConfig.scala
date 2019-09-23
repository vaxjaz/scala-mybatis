package com.jay.li.config

import javax.sql.DataSource
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.annotation.MapperScan
import org.mybatis.spring.{SqlSessionFactoryBean, SqlSessionTemplate}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.TransactionManagementConfigurer

/**
  * @author jay
  * @date 19-9-11 下午2:18  
  *
  */
@Configuration
@MapperScan(Array("com.jay.li.mapper"))
@Autowired
class MybatisConfig(val dataSource: DataSource) extends TransactionManagementConfigurer {

  @Bean
  def sqlSessionFactory: SqlSessionFactory = {
    val sqlSessionFactory = new SqlSessionFactoryBean
    sqlSessionFactory.setDataSource(dataSource)
    sqlSessionFactory.getObject
  }


  @Bean(name = Array("sqlSessionTemplate"))
  def sqlSessionTemplate(sqlSessionFactory: SqlSessionFactory) = new SqlSessionTemplate(sqlSessionFactory)


  override def annotationDrivenTransactionManager(): PlatformTransactionManager = new DataSourceTransactionManager(dataSource)

}
