package com.postdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postdata.Entity.PostEntity;
import com.postdata.service.FbApiService;
import com.restfb.json.JsonArray;

@RestController
public class ApiController {
  @Autowired
  FbApiService fbService;

	@GetMapping("/getData")
	public PostEntity getData() {
		System.out.println("Controller is running****");
	PostEntity insight = fbService.getInsight();
        return insight;
	
	}	
}

