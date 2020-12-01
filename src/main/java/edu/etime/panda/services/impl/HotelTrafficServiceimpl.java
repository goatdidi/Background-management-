package edu.etime.panda.services.impl;


import edu.etime.panda.dao.HotelTrafficMapper;
import edu.etime.panda.pojo.SysArea;
import edu.etime.panda.pojo.Traffic;
import edu.etime.panda.services.interfaces.HotelTrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service

public class HotelTrafficServiceimpl implements HotelTrafficService {
    @Autowired
    private HotelTrafficMapper mapper;

    @Override
    public int insertHotelTraffic(Traffic traffic) {
        return mapper.insert(traffic);
    }

    @Override
    public List<Traffic> selectTrafficlist(Traffic traffic) {
        Example exp = new Example(Traffic.class);
        //处理查询条件
        if (traffic != null) {
            Example.Criteria cr = exp.createCriteria();
            //处理地域状态查询条件
            if (traffic.getHtrstate() != null) {
                cr.andEqualTo("htrstate", traffic.getHtrstate());
            }
            if (traffic.getHotelid() != null && !traffic.getHotelid().equals("")) {
                cr.andEqualTo("hotelid", traffic.getHotelid());
            }


        }
        exp.orderBy("htrsort").asc();
        return mapper.selectByExample(exp);
    }
    @Override
    public Traffic selectTrafficById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Traffic traffic) {
        return mapper.updateByPrimaryKey(traffic);
    }
}
