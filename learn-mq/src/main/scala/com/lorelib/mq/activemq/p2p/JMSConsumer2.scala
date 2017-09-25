package com.lorelib.mq.activemq.p2p

import javax.jms._

import com.lorelib.mq.activemq.ActiveMQConfig
import org.apache.activemq.ActiveMQConnectionFactory

/**
  * @description JMSConsumer2: 消费者，事件通知
  * @author listening
  * @create 2017 07 21 下午3:51.
  */

object JMSConsumer2 extends ActiveMQConfig {
  def main(args: Array[String]): Unit = {
    // 实例化连接工厂
    val connectionFactory: ConnectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL)
    // 创建连接
    val connection: Connection = connectionFactory.createConnection()
    // 启动连接
    connection.start()
    // 创建会话
    val session: Session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)
    // 创建队列
    val destination: Destination = session.createQueue("TEST")
    // 创建消费者
    val consumer: MessageConsumer = session.createConsumer(destination)

    consumer.setMessageListener(new MessageListener {
      override def onMessage(message: Message): Unit = {
        val msg: TextMessage = message.asInstanceOf[TextMessage]
        if (msg != null) {
          println("收到消息：" + msg.getText)
        }
      }
    })

    Thread.sleep(10000)
  }
}
