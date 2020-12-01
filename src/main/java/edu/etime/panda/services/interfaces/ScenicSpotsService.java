package edu.etime.panda.services.interfaces;

import java.util.List;

import edu.etime.panda.pojo.ScenicSpots;
import org.apache.ibatis.annotations.Mapper;
/**
 * 景点管理业务逻辑层接口
 * @author zw
 *
 */

public interface ScenicSpotsService {

	/**
	 * 增加景点信息
	 * @param spots
	 * @return
	 */
	int insertSpots(ScenicSpots spots);
	/**
	 * 查询景点列表
	 * @param spots
	 * @return
	 */
	List<ScenicSpots> selectSpotsList(ScenicSpots spots);
	ScenicSpots selectById(String id);
	int updateSpots(ScenicSpots spots);
}
