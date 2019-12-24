package com.szt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.szt.bean.CarDomain;
import com.szt.service.CService;

@Controller
public class Ccontroller {
		@Autowired
		private CService service;
		@RequestMapping("getList.do")
		private String getList(CarDomain carDomain,Model model,@RequestParam(name="lawAddr",required=false)List<Integer> lawAddr)
		{
			List<CarDomain> list = service.getList(lawAddr);
			model.addAttribute("list", list);
			return "getList";
		}
}
