package com.lorelib.mycat.entity

import scala.beans.BeanProperty

/**
  * @description User: 
  * @author listening
  * @create 2017 07 26 上午9:39.
  */
class User {
  @BeanProperty var id: Long = _
  @BeanProperty var username: String = _
}
