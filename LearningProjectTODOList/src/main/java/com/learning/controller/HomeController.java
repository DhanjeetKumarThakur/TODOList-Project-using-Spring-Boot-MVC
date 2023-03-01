package com.learning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	
	public static List<String> todoList = new ArrayList<>();
	
	@ResponseBody
	@GetMapping("/test")
	public String test() {
		return "testing";
	}
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home Page");
		model.addAttribute("all", todoList);
		return "home";
	}
	
	@PostMapping("/save")
	public String saveNotes(@RequestParam("ToDoList") String todo) {
		todoList.add(todo);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{note}")
	public String delete(@PathVariable("note") String note) {
		todoList.remove(note);
		return "redirect:/";
	}
}
