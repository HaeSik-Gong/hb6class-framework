package com.hb.day02.user.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hb.day02.user.model.GuestUserDao;
import com.hb.day02.user.model.GuestUserVo;

@Controller
public class GuestUserController {

	@Autowired
	private GuestUserDao<GuestUserVo> dao;
	
	@RequestMapping("/user/list")
	public void list(Model model) {
		try {
			model.addAttribute("list", dao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/user/detail")
	public void detail(Model model, @RequestParam("idx") int idx ) {
		try {
			model.addAttribute("bean", dao.selectOne(idx));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("title", "입력");
		model.addAttribute("nxtUrl", "add");
		return "/user/form";
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String insert(@ModelAttribute GuestUserVo bean) {
		try {
			dao.insertOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
	
	@RequestMapping(value = "/user/edit", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam("idx") int idx) {
		try {
			model.addAttribute("title", "수정");
			model.addAttribute("nxtUrl", "edit");
			model.addAttribute("bean", dao.selectOne(idx));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/user/form";
	}
	
	@RequestMapping(value = "/user/edit", method = RequestMethod.POST)
	public String update(@ModelAttribute GuestUserVo bean) {
		try {
			dao.updateOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:detail?idx=" + bean.getNum();
	}
	
	@RequestMapping("/user/delete")
	public String delete(Model model, @RequestParam("idx") int idx ) {
		try {
			model.addAttribute("bean", dao.deleteOne(idx));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
	
}
