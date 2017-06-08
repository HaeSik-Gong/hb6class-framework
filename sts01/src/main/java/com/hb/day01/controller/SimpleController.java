package com.hb.day01.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hb.day01.model.UserDao;

@Controller
public class SimpleController {

	@Autowired
	private UserDao dao;
	
	@RequestMapping("/list")
	public String list(Model model) {
		try {
			model.addAttribute("list", dao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/page/list";
	}
	
	@RequestMapping("/detail/{num}")
	public String detail(Model model, @PathVariable("num") int sabun) {
		try {
			model.addAttribute("bean", dao.selectOne(sabun));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/page/detail";
	}
	
	@RequestMapping("/edit/{num}")
	public String edit(Model model, @PathVariable("num") int sabun) {
		try {
			model.addAttribute("bean", dao.selectOne(sabun));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/page/edit";
	}
	
	@RequestMapping(value="/update", method= RequestMethod.POST)
	public String update(int sabun, String name, int pay) {
		try {
			dao.updateOne(sabun, name, pay);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:detail/"+sabun;
	}
	
	@RequestMapping("/delete/{num}")
	public String delete(@PathVariable("num") int sabun) {
		System.out.println("delete : " + sabun);
		try {
			dao.deleteOne(sabun);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:../list";
	}
	
	@RequestMapping("/add")
	public String addForm() {
		return "/page/add";
	}
	
	@RequestMapping("/insert")
	public String insert(int sabun, String name, int pay) {
		try {
			dao.insertOne(sabun, name, pay);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
	
}
