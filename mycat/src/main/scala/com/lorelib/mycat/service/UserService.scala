package com.lorelib.mycat.service

import com.lorelib.mycat.entity.User
import com.lorelib.mycat.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.{List => JList}

/**
  * @description UserService: 
  * @author listening
  * @create 2017 07 26 上午10:06.
  */
@Service
@Transactional
class UserService @Autowired() (private val userMapper: UserMapper) extends IUserService {
  override def getAll: JList[User] = {
    userMapper.getAll
  }
}
