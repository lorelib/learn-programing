package com.lorelib.mycat.service

import com.lorelib.mycat.entity.TravelRecord
import java.util.{List => JList}

/**
  * @description ITravelRecordService: 
  * @author listening
  * @create 2017 07 26 上午10:07.
  */
trait ITravelRecordService {
  def getAll: JList[TravelRecord]
}
