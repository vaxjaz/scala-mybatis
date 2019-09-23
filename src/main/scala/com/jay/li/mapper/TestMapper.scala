package com.jay.li.mapper

import com.jay.li.entity.ProductType

/**
  * @author jay
  * @date 19-9-11 下午2:32  
  *
  */
trait TestMapper {

  def selectTest(): Int

  def selectOne(id: Long): ProductType

}
