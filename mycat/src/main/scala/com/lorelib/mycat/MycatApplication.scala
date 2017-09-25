package com.lorelib.mycat

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
  * @description MycatApplication: 
  * @author listening
  * @create 2017 07 26 上午9:44.
  */
@SpringBootApplication
@EnableTransactionManagement
class MycatApplication {

}

object MycatApplication {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[MycatApplication], args:_*)
  }
}
