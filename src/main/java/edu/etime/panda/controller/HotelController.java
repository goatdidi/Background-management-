package edu.etime.panda.controller;

import edu.etime.panda.pojo.Hotel;
import edu.etime.panda.pojo.HotelType;

import edu.etime.panda.services.interfaces.HotelService;

import edu.etime.panda.services.interfaces.HotelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService service;
    @Autowired
    private HotelTypeService typeservice;



    @RequestMapping("/toadd")
    public String toadd(Model model) {
        // 查询出所有可用的景点地域(直接使用SysAreaService中的查询列表方法)
        HotelType type = new HotelType();
        type.setTypestate(1);
        List<HotelType> typelist = typeservice.selectTypelist(type);
        model.addAttribute("typelist", typelist);
        return "hotel/add";
    }
    @RequestMapping("/add")
    public String add(Hotel hotel, @RequestParam("file") MultipartFile file , Model model) {
        // 生成id主键
        hotel.setHotelid(UUID.randomUUID().toString());
        // 处理景点地域id和地域名称属性
        String[] strs = hotel.getHoteltypeid().split(",");
        hotel.setHoteltypeid(strs[0]);
        hotel.setHoteltypename(strs[1]);
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
                hotel.setHotelimg("/upload/"+newname);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int rtn = service.insertHotel(hotel);
        // 处理结果
        if (rtn > 0) {
            // 成功，返回到列表中
            return "redirect:/hotel/list";
        } else {
            model.addAttribute("msg", "增加酒店失败");
            return "redirect:/hotel/toadd";
        }
    }
    @RequestMapping("/list")
    public String list(Hotel hotel,Model model){
        //1、查询可用景点地域列表
        HotelType type = new HotelType();
        type.setTypestate(1);
        List<HotelType> typelist = typeservice.selectTypelist(type);
        //2、查询景点列表
        List<Hotel> list = service.selectHotelList(hotel);
        model.addAttribute("typelist", typelist);
        model.addAttribute("list", list);
        return "hotel/list";
    }

    @RequestMapping("/toedit/{id}")
    public String toupdate(@PathVariable String id, Model model) {
        Hotel ho = new Hotel();
        ho = service.selectById(id);
        model.addAttribute("hotel", ho);
        HotelType type = new HotelType();
        type.setTypestate(1);
        List<HotelType> typelist = typeservice.selectTypelist(type);
        model.addAttribute("typelist", typelist);
        return "hotel/edit";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("file") MultipartFile file ,Hotel hotel,Model model) {

        String[] strs = hotel.getHoteltypeid().split(",");
        hotel.setHoteltypeid(strs[0]);
        hotel.setHoteltypename(strs[1]);
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
                hotel.setHotelimg("/upload/"+newname);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int res = service.updateHotel(hotel);
        if (res > 0) {
            // 成功，返回到列表中
            return "redirect:/hotel/list";
        } else {
            model.addAttribute("msg", "增加地域失败");
            return "redirect:/hotel/edit";
        }
    }
}
