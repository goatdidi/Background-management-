package edu.etime.panda.controller;
import java.util.List;
import java.util.UUID;

import edu.etime.panda.pojo.HotelType;

import edu.etime.panda.pojo.SysArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.etime.panda.services.interfaces.HotelTypeService;
@Controller
@RequestMapping("/type")

public class HotelTypeController {
    @Autowired
    private HotelTypeService service;
    @RequestMapping("/toadd")
    public String toadd(){
        return "type/add";
    }

    @RequestMapping("/add")
    public String add(HotelType type, Model model){
        //生成主键
        type.setTypeid(UUID.randomUUID().toString());
        //调用service层的方法
        int rtn = service.insertHotelType(type);
        //处理结果
        if(rtn>0){
            //成功，返回到列表中
            return "redirect:/type/list";
        }else{
            model.addAttribute("msg", "增加类型失败");
            return "redirect:/type/toadd";
        }
    }
    @RequestMapping("/list")
    public String list(HotelType type, Model model){
        List<HotelType> list = service.selectTypelist(type);
        model.addAttribute("list", list);
        return "type/list";
    }
    @RequestMapping("/toedit/{id}")
    public String toedit(@PathVariable("id")String id,Model model){
        HotelType type = service.selectTypeById(id);
        model.addAttribute("type", type);
        return "type/edit";
    }
    @RequestMapping("/edit")
    public String edit(HotelType type,Model model){
        int rtn = service.updateHotelType(type);
        if(rtn>0){
            //成功，返回到列表中
            return "redirect:/type/list";
        }else{
            model.addAttribute("msg", "修改酒店类型失败");
            return "redirect:/type/toedit";
        }

    }
}
