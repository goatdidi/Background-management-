package edu.etime.panda.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.etime.panda.dao.SysAreaMapper;
import edu.etime.panda.pojo.SysArea;
import edu.etime.panda.services.interfaces.SysAreaService;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * 景点地域管理服务层实现类
 * @author zw
 *
 */
@Service
public class SysAreaServiceImpl implements SysAreaService {

	@Autowired
	private SysAreaMapper mapper;
	
	@Override
	public int insertSysArea(SysArea area) {
		return mapper.insert(area);
	}

	@Override
	public List<SysArea> selectArealist(SysArea area) {
		Example exp = new Example(SysArea.class);
		//处理查询条件
		if(area!=null){
			Criteria cr = exp.createCriteria();
			//处理地域状态查询条件
			if(area.getAreastate()!=null){
				cr.andEqualTo("areastate", area.getAreastate());
			}
			//处理地域名称查询条件（模糊查询）
			if(area.getAreaname()!=null && !area.getAreaname().equals("")){
				cr.andLike("areaname", "%"+area.getAreaname()+"%");
			}
		}
		//处理排序
		exp.orderBy("areasort").asc();
		return mapper.selectByExample(exp);
	}

	@Override
	public SysArea selectAreaById(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateSysArea(SysArea area) {
		return mapper.updateByPrimaryKey(area);
	}

}
