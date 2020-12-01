package edu.etime.panda.services.interfaces;

import java.util.List;

import edu.etime.panda.pojo.SysArea;
import org.apache.ibatis.annotations.Mapper;

/**
 * 景点地域管理接口
 * @author zw
 *
 */

public interface SysAreaService {

	/**
	 * 增加地域
	 * @param area
	 * @return
	 */
	int insertSysArea(SysArea area);
	/**
	 * 查询地域列表
	 * @return
	 */
	List<SysArea> selectArealist(SysArea area);
	/**
	 * 根据id查询一条景点地域的详细信息
	 * @param id
	 * @return
	 */
	SysArea selectAreaById(String id);
	/**
	 * 修改景点地域
	 * @param area
	 * @return
	 */
	int updateSysArea(SysArea area);
	
}
