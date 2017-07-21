package com.lorelib.mq.activemq

import org.apache.activemq.ActiveMQConnection

/**
  * @description ActiveMQConfig: 
  * @author listening
  * @create 2017 07 21 下午3:52.
  */

trait ActiveMQConfig {
  val USERNAME: String = ActiveMQConnection.DEFAULT_USER
  val PASSWORD: String = ActiveMQConnection.DEFAULT_PASSWORD
  val BROKEURL: String = ActiveMQConnection.DEFAULT_BROKER_URL
}
