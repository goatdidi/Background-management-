package edu.etime.panda.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.etime.panda.pojo.SysArea;
import edu.etime.panda.services.interfaces.SysAreaService;

/**
 * 景点地域管理的控制层
 * @author zw
 *
 */

@Controller
@RequestMapping("/area")
public class SysAreaController {

	@Autowired
	private SysAreaService service;
	
	/**
	 * 进入到增加地域的方法
	 * @return
	 */
	@RequestMapping("/toadd")
	public String toadd(){
		return "area/add";
	}
	/**
	 * 增加景点地域
	 * @param area
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(SysArea area,Model model){
		//生成主键
		area.setAreaid(UUID.randomUUID().toString());
		//调用service层的方法
		int rtn = service.insertSysArea(area);
		//处理结果
		if(rtn>0){
			//成功，返回到列表中
			return "redirect:/area/list";
		}else{
			model.addAttribute("msg", "增加地域失败");
			return "redirect:/area/toadd";
		}
	}
	/**
	 * 查询景点地域列表
	 * @param area
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(SysArea area,Model model){
		List<SysArea> list = service.selectArealist(area);
		model.addAttribute("list", list);
		return "area/list";
	}
	/**
	 * 初始化修改页面
	 * @param id 需要修改的记录id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toedit/{id}")
	public String toedit(@PathVariable("id")String id,Model model){
		SysArea area = service.selectAreaById(id);
		model.addAttribute("area", area);		
		return "area/edit";
	}
	/**
	 * 修改地域
	 * @param area
	 * @param model
	 */
	@RequestMapping("/edit")
	public String edit(SysArea area,Model model){
		int rtn = service.updateSysArea(area);
		if(rtn>0){
			//成功，返回到列表中
			return "redirect:/area/list";
		}else{
			model.addAttribute("msg", "修改地域失败");
			return "redirect:/area/toedit";
		}
		
	}
}










