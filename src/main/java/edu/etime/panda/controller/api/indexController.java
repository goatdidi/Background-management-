package edu.etime.panda.controller.api;

import edu.etime.panda.pojo.Hotel;
import edu.etime.panda.pojo.HotelType;
import edu.etime.panda.services.interfaces.HotelService;
import edu.etime.panda.services.interfaces.HotelTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class indexController {

    @Resource
    private HotelService hotelService;

    @Resource
    private HotelTypeService hotelTypeService;

    @GetMapping("data")
    public List<Hotel> data(){
        Hotel hotel = new Hotel();
        return hotelService.selectHotelList(hotel);
    }

    @GetMapping("type")
    public List<HotelType> type(){
        HotelType hotelType = new HotelType();
        return hotelTypeService.selectTypelist(hotelType);
    }

    @GetMapping("hotel/{typeId}")
    public List<Hotel> hotel(@PathVariable String typeId){
        return hotelService.selectByType(typeId);
    }
}
