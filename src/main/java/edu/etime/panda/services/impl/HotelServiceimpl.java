package edu.etime.panda.services.impl;


import edu.etime.panda.dao.HotelDao;
import edu.etime.panda.dao.HotelMapper;
import edu.etime.panda.pojo.Hotel;
import edu.etime.panda.pojo.ScenicSpots;
import edu.etime.panda.services.interfaces.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import javax.annotation.Resource;
import java.util.List;


@Service
public class HotelServiceimpl implements HotelService {
    @Resource
    private HotelMapper mapper;

    @Resource
    private HotelDao dao;

    public int insertHotel(Hotel hotel){
        return mapper.insertSelective(hotel);

    }
    @Override
    public List<Hotel> selectHotelList(Hotel hotel){
        Example exp = new Example(Hotel.class);
        if(hotel!=null){
            Criteria cr = exp.createCriteria();

            //spotsstate
            if(hotel.getHotelstate()!=null){
                cr.andEqualTo("hotelstate",hotel.getHotelstate());
            }
            //spotsareaid
            if(hotel.getHoteltypeid()!=null && !hotel.getHoteltypeid().equals("")){
                cr.andEqualTo("hoteltypeid", hotel.getHoteltypeid());
            }
            if(hotel.getHotelname()!=null && !hotel.getHotelname().equals("")){
                cr.andLike("hotelname", "%"+hotel.getHotelname()+"%");
            }
        }
        return mapper.selectByExample(exp);
    }
    @Override
    public Hotel selectById(String id){

        return mapper.selectByPrimaryKey(id);

    }
    public int updateHotel(Hotel hotel){
        return mapper.updateByPrimaryKeySelective(hotel);
    }

    @Override
    public List<Hotel> selectByType(String typeId) {
        return dao.selectByType(typeId);
    }
}
