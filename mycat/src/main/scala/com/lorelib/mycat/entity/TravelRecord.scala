package com.lorelib.mycat.entity

import java.util.Date

import scala.beans.BeanProperty

/**
  * @description TravelRecord: 
  * @author listening
  * @create 2017 07 26 上午9:59.
  */
class TravelRecord {
  @BeanProperty var id: Long = _
  @BeanProperty var userId: String = _
  @BeanProperty var travelData: Date = _
  @BeanProperty var fee: BigDecimal = _
  @BeanProperty var days: Int = _
}
