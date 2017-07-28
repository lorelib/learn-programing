package com.lorelib.mycat.mapper

import com.lorelib.mycat.entity.User
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Component

import java.util.{List => JList}

/**
  * @description UserMapper: 
  * @author listening
  * @create 2017 07 26 上午9:42.
  */
@Component
@Mapper
trait UserMapper {
  def getAll: JList[User]
}
