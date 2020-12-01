package edu.etime.panda.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.etime.panda.dao.ScenicSpotsMapper;
import edu.etime.panda.pojo.ScenicSpots;
import edu.etime.panda.services.interfaces.ScenicSpotsService;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * 景点管理业务逻辑层实现类
 * @author zw
 *
 */
@Service
public class ScenicSpotsServiceImpl implements ScenicSpotsService {

	@Autowired
	private ScenicSpotsMapper mapper;
	/**
	 * 说明:insert;insertSelective的区别：
	 * insert会将所有的属性都会插入到数据库中；
	 * insertSelective：如果某属性的值为null，那么不插入此这个字段
	 */
	@Override
	public int insertSpots(ScenicSpots spots) {
		return mapper.insertSelective(spots);
	}
	
	@Override
	public List<ScenicSpots> selectSpotsList(ScenicSpots spots) {
		//处理查询条件
		Example exp = new Example(ScenicSpots.class);
		if(spots!=null){
			Criteria cr = exp.createCriteria();
			//spotsfirst
			if(spots.getSpotsfirst()!=null){
				cr.andEqualTo("spotsfirst", spots.getSpotsfirst());
			}
			//spotshot
			if(spots.getSpotshot()!=null){
				cr.andEqualTo("spotshot", spots.getSpotshot());
			}
			//spotsstate
			if(spots.getSpotsstate()!=null){
				cr.andEqualTo("spotsstate",spots.getSpotsstate());
			}
			//spotsareaid
			if(spots.getSpotsareaid()!=null && !spots.getSpotsareaid().equals("")){
				cr.andEqualTo("spotsareaid", spots.getSpotsareaid());
			}
			if(spots.getSpotsname()!=null && !spots.getSpotsname().equals("")){
				cr.andLike("spotsname", "%"+spots.getSpotsname()+"%");
			}
		}
		return mapper.selectByExample(exp);
	}

	@Override
	public ScenicSpots selectById(String id) {
		// TODO Auto-generated method stub
		;
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateSpots(ScenicSpots spots) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(spots);
	}

}
