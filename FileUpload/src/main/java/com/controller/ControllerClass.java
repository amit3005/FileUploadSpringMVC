package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerClass {

	@RequestMapping("/form")
	public ModelAndView form()
	{
		return new ModelAndView("form");
		
	}
	
	@RequestMapping(value="save" ,  method=RequestMethod.POST)
	public ModelAndView save(@RequestParam("file") CommonsMultipartFile file , HttpSession s) throws IOException
	{
		String str=s.getServletContext().getRealPath("/images");
		String s1=file.getOriginalFilename();
		byte[] b=file.getBytes();
		FileOutputStream f=new FileOutputStream(str+File.separator+s1);
		{
			f.write(b);
			f.flush();
		} 
		System.out.println(str);
		return new ModelAndView("form");
	}
}
