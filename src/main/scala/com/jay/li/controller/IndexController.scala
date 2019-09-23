package com.jay.li.controller

import com.jay.li.entity.ProductType
import com.jay.li.mapper.TestMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{PathVariable, RequestMapping, RestController}

/**
  * @author jay
  * @date 19-9-11 上午11:29  
  *
  */
@RestController
@Autowired
class IndexController(mapper: TestMapper) {

  @RequestMapping(value = Array("/index"))
  def index(): String = {
    val result = mapper.selectTest()
    result + ""
  }

  @RequestMapping(value = Array("/select/{id}"))
  def select(@PathVariable("id") id: Long): ProductType = {
    mapper.selectOne(id)
  }

}
