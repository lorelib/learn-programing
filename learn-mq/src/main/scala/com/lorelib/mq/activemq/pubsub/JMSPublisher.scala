package com.lorelib.mq.activemq.pubsub

import javax.jms._

import com.lorelib.mq.activemq.ActiveMQConfig
import org.apache.activemq.ActiveMQConnectionFactory

/**
  * @description JMSPublisher: 消息发布者
  * @author listening
  * @create 2017 07 21 下午4:48.
  */

object JMSPublisher extends ActiveMQConfig {
  def main(args: Array[String]): Unit = {
    val connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL)
    val connection = connectionFactory.createConnection()
    connection.start()

    val session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE).asInstanceOf[TopicSession]
    val topic = session.createTopic("Topic01")
    val publisher = session.createPublisher(topic)

    for (i <- 1 to 10) {
      val msg = session.createTextMessage("Hello Topic" + i)
      println("发送消息：" + msg.getText)
      publisher.publish(topic, msg)
    }

    session.commit()
  }
}
