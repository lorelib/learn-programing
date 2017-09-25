package com.lorelib.mycat.service

import com.lorelib.mycat.entity.TravelRecord
import com.lorelib.mycat.mapper.TravelRecordMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.{List => JList}

/**
  * @description TravelRecordService: 
  * @author listening
  * @create 2017 07 26 上午10:06.
  */
@Service
@Transactional
class TravelRecordService @Autowired() (private val travelRecordMapper: TravelRecordMapper) extends ITravelRecordService {
  override def getAll: JList[TravelRecord] = {
    travelRecordMapper.getAll
  }
}
