package edu.etime.panda.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.etime.panda.pojo.ScenicSpots;
import edu.etime.panda.pojo.SysArea;
import edu.etime.panda.services.interfaces.ScenicSpotsService;
import edu.etime.panda.services.interfaces.SysAreaService;

/**
 * 景点管理控制层
 *
 * @author zw
 *
 */
@Controller
@RequestMapping("/spots")
public class ScenicSpotsController {

	@Autowired
	private SysAreaService areaservice;

	@Autowired
	private ScenicSpotsService service;

	/**
	 * 初始化增加页面
	 *
	 * @return
	 */
	@RequestMapping("/toadd")
	public String toadd(Model model) {
		// 查询出所有可用的景点地域(直接使用SysAreaService中的查询列表方法)
		SysArea area = new SysArea();
		area.setAreastate(1);
		List<SysArea> arealist = areaservice.selectArealist(area);
		model.addAttribute("arealist", arealist);
		return "spots/add";
	}

	/**
	 * 增加景点
	 *
	 * @param spots
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(ScenicSpots spots,@RequestParam("file") MultipartFile file ,Model model) {
		// 生成id主键
		spots.setSpotsid(UUID.randomUUID().toString());
		// 处理景点地域id和地域名称属性
		String[] strs = spots.getSpotsareaid().split(",");
		spots.setSpotsareaid(strs[0]);
		spots.setSpotsareaname(strs[1]);
		//文件上传
		if(file!=null && file.getSize()>0){
			//上传文件的相对地址
			String path = "src/main/resources/static/upload/";
			//创建目录（判断目录是否存在，不存在则需要进行创建）
			File dir = new File(path);
			if(!dir.isDirectory()){
				dir.mkdirs();
			}
			String oldname = file.getOriginalFilename();//原来文件的名称
			String extname = oldname.substring(oldname.lastIndexOf("."));//文件后缀名
			String newname = UUID.randomUUID().toString()+extname;
			//保存文件的绝对路径
			File f = new File(dir.getAbsoluteFile()+"\\"+newname);
			try {
				file.transferTo(f);
				//保存到数据库中的文件路径
				spots.setSpotsimg("/upload/"+newname);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		int rtn = service.insertSpots(spots);
		// 处理结果
		if (rtn > 0) {
			// 成功，返回到列表中
			return "redirect:/spots/list";
		} else {
			model.addAttribute("msg", "增加地域失败");
			return "redirect:/spots/toadd";
		}
	}
	/**
	 * 查询景点列表
	 * @param spots
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(ScenicSpots spots,Model model){
		//1、查询可用景点地域列表
		SysArea area = new SysArea();
		area.setAreastate(1);
		List<SysArea> arealist = areaservice.selectArealist(area);
		//2、查询景点列表
		List<ScenicSpots> list = service.selectSpotsList(spots);
		model.addAttribute("arealist", arealist);
		model.addAttribute("list", list);
		return "spots/list";
	}

	@RequestMapping("/toedit/{id}")
	public String toupdate(@PathVariable String id,Model model) {
		ScenicSpots sp = new ScenicSpots();
		sp = service.selectById(id);
		model.addAttribute("spots", sp);
		SysArea area = new SysArea();
		area.setAreastate(1);
		List<SysArea> arealist = areaservice.selectArealist(area);
		model.addAttribute("arealist", arealist);
		return "spots/update";
	}

	@RequestMapping("/edit")
	public String update(@RequestParam("file") MultipartFile file ,ScenicSpots spots,Model model) {

		String[] strs = spots.getSpotsareaid().split(",");
		spots.setSpotsareaid(strs[0]);
		spots.setSpotsareaname(strs[1]);
		if(file!=null && file.getSize()>0){
			//上传文件的相对地址
			String path = "src/main/resources/static/upload/";
			//创建目录（判断目录是否存在，不存在则需要进行创建）
			File dir = new File(path);
			if(!dir.isDirectory()){
				dir.mkdirs();
			}
			String oldname = file.getOriginalFilename();//原来文件的名称
			String extname = oldname.substring(oldname.lastIndexOf("."));//文件后缀名
			String newname = UUID.randomUUID().toString()+extname;
			//保存文件的绝对路径
			File f = new File(dir.getAbsoluteFile()+"\\"+newname);
			try {
				file.transferTo(f);
				//保存到数据库中的文件路径
				spots.setSpotsimg("/upload/"+newname);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int res = service.updateSpots(spots);
		if (res > 0) {
			// 成功，返回到列表中
			return "redirect:/spots/list";
		} else {
			model.addAttribute("msg", "增加地域失败");
			return "redirect:/spots/update";
		}
	}


}



