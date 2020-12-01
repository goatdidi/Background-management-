package edu.etime.panda.services.interfaces;

import edu.etime.panda.pojo.Hotel;
import edu.etime.panda.pojo.ScenicSpots;


import java.util.List;


public interface HotelService {
    int insertHotel(Hotel hotel);
    List<Hotel> selectHotelList(Hotel hotel);
    Hotel selectById(String id);
    int updateHotel(Hotel hotel);

    List<Hotel> selectByType(String typeId);
}
