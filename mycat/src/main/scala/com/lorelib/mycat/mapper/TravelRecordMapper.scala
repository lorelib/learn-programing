package com.lorelib.mycat.mapper

import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Component
import java.util.{List => JList}

import com.lorelib.mycat.entity.TravelRecord

/**
  * @description TravelRecordMapper:
  * @author listening
  * @create 2017 07 26 上午9:42.
  */
@Component
@Mapper
trait TravelRecordMapper {
  def getAll(): JList[TravelRecord]
}
