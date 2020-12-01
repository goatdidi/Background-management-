package edu.etime.panda.dao;

import edu.etime.panda.pojo.Hotel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HotelDao {

    @Select("select * from hotel where hotelTypeId = #{typeId}")
    List<Hotel> selectByType(String typeId);
}
