package edu.etime.panda.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * ckeditor文件上传
 * @author zw
 *
 */
@Controller
@RequestMapping("/ckeditor/upload")
public class CKEditorController {
	
	@RequestMapping("/img")
	public void uploadimg(@RequestParam("upload") MultipartFile file,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		String realpath = "src/main/resources/static/upload/";
		File dir = new File(realpath);
		if(!dir.isDirectory()){
			dir.mkdirs();
		}
		String oldname = file.getOriginalFilename();
		String extname = oldname.substring(oldname.lastIndexOf("."));
		String newname = UUID.randomUUID().toString()+extname;
		File f = new File(dir.getAbsoluteFile()+"\\"+newname);
		file.transferTo(f);
		String url = "/upload/"+newname;
		
		response.setContentType("text/html;charset=UTF-8");
		String callback = request.getParameter("CKEditorFuncNum");
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + url + "',''" + ")");
		out.println("</script>");
		out.flush();
		out.close();
	}
}
