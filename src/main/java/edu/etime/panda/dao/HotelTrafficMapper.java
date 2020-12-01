package edu.etime.panda.dao;

import edu.etime.panda.pojo.HotelType;
import edu.etime.panda.pojo.Traffic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HotelTrafficMapper extends tk.mybatis.mapper.common.Mapper<Traffic>{
}
