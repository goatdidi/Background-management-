package edu.etime.panda.controller;

import edu.etime.panda.pojo.Hotel;

import edu.etime.panda.pojo.HotelTraffic;
import edu.etime.panda.pojo.Traffic;
import edu.etime.panda.services.interfaces.HotelService;
import edu.etime.panda.services.interfaces.HotelTrafficService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/traffic")
public class HotelTrafficController {

    @Autowired
    private HotelTrafficService service;

    @Autowired
    private HotelService hotelservice;


    @RequestMapping("/toadd")
    public String toadd(Model model){
        Hotel hotel = new Hotel();
        hotel.setHotelstate(1);
        List<Hotel> hotels = hotelservice.selectHotelList(hotel);
        model.addAttribute("hotellist",hotels);
        return "traffic/add";
    }


    @RequestMapping("/add")
    public String add(Traffic traffic, Model model){

        //生成主键
        traffic.setHtrid(UUID.randomUUID().toString());
        //调用service层的方法

        int rtn = service.insertHotelTraffic(traffic);
        //处理结果
        if(rtn>0){
            //成功，返回到列表中
            return "redirect:/traffic/list";
        }else{
            model.addAttribute("msg", "增加交通状况失败");
            return "redirect:/traffic/toadd";
        }
    }


    @RequestMapping("/list")
    public String list(Traffic traffic, Model model){
        //1、查询可用景点地域列表
        Hotel hotel = new Hotel();
        List<HotelTraffic> hotelTraffics = new ArrayList<>();
        hotel.setHotelstate(1);
        List<Hotel> hotellist = hotelservice.selectHotelList(hotel);
        //2、查询景点列表
        List<Traffic> list = service.selectTrafficlist(traffic);
        for (Traffic newTraffic : list) {
            HotelTraffic hotelTraffic = new HotelTraffic();
            BeanUtils.copyProperties(newTraffic,hotelTraffic);
            Hotel newHotel = hotelservice.selectById(newTraffic.getHotelid());
            String hotelname = newHotel.getHotelname();
            hotelTraffic.setHotelname(hotelname);
            hotelTraffics.add(hotelTraffic);
        }
        model.addAttribute("hotellist", hotellist);
        model.addAttribute("list", hotelTraffics);

        return "traffic/list";
    }

    @RequestMapping("/toedit/{id}")
    public String toedit(@PathVariable("id")String id, Model model){
        Traffic traffic = service.selectTrafficById(id);
        Hotel hotel = hotelservice.selectById(traffic.getHotelid());
        model.addAttribute("hotel",hotel);
        model.addAttribute("traffic", traffic);

        return "traffic/edit";
    }

    @RequestMapping("/edit")
    public String edit(Traffic traffic,Model model){
        int rtn = service.update(traffic);
        if(rtn>0){
            //成功，返回到列表中
            return "redirect:/traffic/list";
        }else{
            model.addAttribute("msg", "修改交通类型失败");
            return "redirect:/traffic/toedit";
        }

    }
}
