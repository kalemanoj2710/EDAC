package com.app.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //mandatory
@RequestMapping("/test") //optional BUT recommended for separation
public class TestController {
	public TestController() {
		System.out.println("in ctor of "+getClass().getName());
	}
	//add a req handling method for testing Model n View
	@GetMapping("/hello1")//@GetMapping => @RequestMapping + handling request method=get
	public ModelAndView testMe()
	{
		System.out.println("in test me");
		//o.s.w.s.ModelView : class : constr : (String viewName,String modelAttrName,Object modelAttr)
		return new ModelAndView("/welcome", "server_ts", LocalDateTime.now());
	}
	//add a request hanbdling method : for testing Model map n req params
	@GetMapping("/hello2")
	//SC / WC : int start=Integer.parseInt(request.getParamter("start");
	//SC / WC : int endValue=Integer.parseInt(request.getParamter("end");
	public String testModelMap(@RequestParam int start,@RequestParam(name = "end") int endValue,
			Model modelMap) // D.I : SC injects EMPTY map to store model attributes
	{
		
		System.out.println("in test model map "+start+" "+endValue+" map : "+modelMap);//10 50 {}
		List<Integer> numList=IntStream.rangeClosed(start, endValue).//stream of prim types : int : IntStream
		boxed().//Stream<Integer>
		collect(Collectors.toList());
		//add 2 attributes in the map : time stamp n number list
		modelMap.addAttribute("server_ts", LocalDateTime.now()).addAttribute("num_list", numList);		
		return "/test/display";//actual view name returned by V.R : /WEB-INF/views/test/display.jsp
	}
	

}
