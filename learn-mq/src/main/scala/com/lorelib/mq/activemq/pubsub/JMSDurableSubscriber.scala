package com.lorelib.mq.activemq.pubsub

import javax.jms.{Session, TextMessage, TopicSession}

import com.lorelib.mq.activemq.ActiveMQConfig
import org.apache.activemq.ActiveMQConnectionFactory

/**
  * @description JMSDurableSubscriber: 
  * @author listening
  * @create 2017 07 21 下午5:31.
  */

object JMSDurableSubscriber extends ActiveMQConfig {
  def main(args: Array[String]): Unit = {
    val connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL)
    val connection = connectionFactory.createConnection()
    connection.setClientID("sub01")
    connection.start()

    val session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE).asInstanceOf[TopicSession]
    val topic = session.createTopic("Topic01")
    val subscriber = session.createDurableSubscriber(topic, "sub01")
    while (true) {
      val msg = subscriber.receive(1000).asInstanceOf[TextMessage]
      if (msg != null) println("订阅主题：" + subscriber.getTopic.getTopicName + "，消息内容：" + msg.getText)
    }
  }
}
