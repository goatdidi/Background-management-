package edu.etime.panda.services.impl;

import edu.etime.panda.dao.HotelTypeMapper;
import edu.etime.panda.pojo.HotelType;

import edu.etime.panda.services.interfaces.HotelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class HotelTypeServiceimpl implements HotelTypeService {
    @Autowired
    private HotelTypeMapper mapper;



    public int insertHotelType(HotelType type){
        return mapper.insert(type);

    }
    @Override
    public List<HotelType> selectTypelist(HotelType type) {
        Example exp = new Example(HotelType.class);
        //处理查询条件
        if(type!=null){
            Example.Criteria cr = exp.createCriteria();
            //处理地域状态查询条件
            if(type.getTypestate()!=null){
                cr.andEqualTo("typestate", type.getTypestate());
            }
            //处理地域名称查询条件（模糊查询）
            if(type.getTypename()!=null && !type.getTypename().equals("")){
                cr.andLike("typename", "%"+type.getTypename()+"%");
            }
        }
        //处理排序
        exp.orderBy("typesort").asc();
        return mapper.selectByExample(exp);
    }
    public HotelType selectTypeById(String id){return mapper.selectByPrimaryKey(id);

    }
    public int updateHotelType(HotelType type){
        return mapper.updateByPrimaryKey(type);
    }
}
