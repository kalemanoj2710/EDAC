package com.app.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.ErrorResponse;

@ControllerAdvice // stereotype annotation . Class level annotation .
//Supplies common advice to all controllers  n rest controllers.
public class GlobalExceptionHandler{

	// handle ANY other exception
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAnyException(Exception exc, HttpServletRequest req) {
		System.out.println("in handle exc");
		ErrorResponse errResp = new ErrorResponse(exc.getMessage(), req.getRequestURI());
		ModelAndView view = new ModelAndView();
		view.addObject("error", errResp);
		view.setViewName("/error/error");
		return view;
	}

}