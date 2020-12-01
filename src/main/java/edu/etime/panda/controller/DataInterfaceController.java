package edu.etime.panda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.etime.panda.pojo.ScenicSpots;
import edu.etime.panda.pojo.SysArea;
import edu.etime.panda.services.interfaces.ScenicSpotsService;
import edu.etime.panda.services.interfaces.SysAreaService;


@RestController
@RequestMapping("/data")
@CrossOrigin
public class DataInterfaceController {

	@Autowired
	private SysAreaService service;
	
	@Autowired
	private ScenicSpotsService spotsservice;
	
	/**
	 * 查询景点地域列表的数据接口
	 * @return
	 */
	@RequestMapping("/area")
	public List<SysArea> selectSysArea(){
		SysArea area = new SysArea();
		area.setAreastate(1);
		List<SysArea> list = service.selectArealist(area);
		return list;
	}
	/**
	 * 根据景点地域查询热门景点列表
	 * @return
	 */
	@RequestMapping("/hotspots/{areaid}")
	@CrossOrigin
	public List<ScenicSpots> selectHotSpots(@PathVariable("areaid")String areaid){
		ScenicSpots spots = new ScenicSpots();
		spots.setSpotsareaid(areaid); //地域
		spots.setSpotshot(1);	//热门
		spots.setSpotsstate(1);	//正常
		List<ScenicSpots> list = spotsservice.selectSpotsList(spots);
		return list;
	}
	@RequestMapping("/spots")
	public List<ScenicSpots> selectSpotsList(){
		ScenicSpots spots = new ScenicSpots();
		List<ScenicSpots> list= spotsservice.selectSpotsList(spots);
		return list;
	}
	
	
}
