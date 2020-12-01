package edu.etime.panda.dao;

import org.apache.ibatis.annotations.Mapper;

import edu.etime.panda.pojo.ScenicSpots;

/**
 * 景点管理dao层
 * @author zw
 *
 */
@Mapper
public interface ScenicSpotsMapper extends tk.mybatis.mapper.common.Mapper<ScenicSpots> {

}
