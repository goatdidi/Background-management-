package edu.etime.panda.services.interfaces;


import edu.etime.panda.pojo.SysArea;
import edu.etime.panda.pojo.Traffic;

import java.util.List;

public interface HotelTrafficService {
    int insertHotelTraffic(Traffic traffic);
    List<Traffic> selectTrafficlist(Traffic traffic);
    Traffic selectTrafficById(String id);
    int update(Traffic traffic);
}
