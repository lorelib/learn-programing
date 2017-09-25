package com.lorelib.mycat.service

import com.lorelib.mycat.entity.User
import java.util.{List => JList}

/**
  * @description IUserService: 
  * @author listening
  * @create 2017 07 26 上午10:06.
  */
trait IUserService {
  def getAll: JList[User]
}
