package edu.etime.panda.services.interfaces;
import edu.etime.panda.pojo.HotelType;
import edu.etime.panda.pojo.SysArea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;



public interface HotelTypeService {
    int insertHotelType(HotelType type);
    List<HotelType> selectTypelist(HotelType type);
    HotelType selectTypeById(String id);
    int updateHotelType(HotelType type);
}
