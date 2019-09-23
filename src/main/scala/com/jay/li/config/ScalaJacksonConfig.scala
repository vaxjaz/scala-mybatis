package com.jay.li.config

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import org.springframework.context.annotation.{Bean, Configuration}

/**
  * @author jay
  * @date 19-9-11 下午4:17  
  *
  */
@Configuration
class ScalaJacksonConfig {

  @Bean
  def mapper: ObjectMapper = {
    val mapper = new ObjectMapper() with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    mapper
  }

}
