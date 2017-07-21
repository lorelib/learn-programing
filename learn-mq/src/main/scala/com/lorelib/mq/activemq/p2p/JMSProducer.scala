package com.lorelib.mq.activemq.p2p

import javax.jms._

import org.apache.activemq.ActiveMQConnectionFactory

/**
  * @description JMSProducer: 消息生产者
  * @author listening
  * @create 2017 07 21 下午2:45.
  */

object JMSProducer extends ActiveMQConfig {
  def sendMsg(session: Session, msgProducer: MessageProducer): Unit = {
    val content = "Hello listening"
    val msg: TextMessage = session.createTextMessage(content)
    println("发送消息：" + content)
    msgProducer.send(msg)
  }

  def main(args: Array[String]): Unit = {
    // 实例化连接工厂
    val connectionFactory: ConnectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL)
    // 通过连接工厂获取连接
    val connection: Connection = connectionFactory.createConnection()
    // 启动连接
    connection.start()
    // 创建session
    val session: Session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE) // 第一个参数表示是否开启事务
    // 创建一个名称为TEST的消息队列
    val destination: Destination = session.createQueue("TEST")
    // 创建消息生产者
    val msgProducer: MessageProducer = session.createProducer(destination)
    // 发送消息
    sendMsg(session, msgProducer)

    session.commit()
  }
}
