package com.hanains.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanains.guestbook.dao.GuestbookDao;
import com.hanains.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {

	
	@Autowired
	private GuestbookDao guestbookDao;
	
	@RequestMapping("/")
	public String index(Model model){
		List<GuestbookVo> list = guestbookDao.getList();
		model.addAttribute("list",list);
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute GuestbookVo vo){
		guestbookDao.insert(vo);
		return "redirect:";
	}
	
	@RequestMapping("/deleteform")
	public String deleteform(){
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@ModelAttribute GuestbookVo vo){
		guestbookDao.delete(vo);
		return "redirect:";
	}
	
	
}
