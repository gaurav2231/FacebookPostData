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

         // Response on postman
//  {
//     "createdtime": "\"2022-02-02T11:41:54+0000\"",
//     "message": "\"Ftechiz Solutions is a Leading Provider of Blockchain Development company  along with Web and Mobile Development across the globe. #iOS #Android #Blockchain #Window# MEAN stack # MERN stack #AWS\"",
//     "id": "\"1805257253087224_3145279089085027\"",
//     "before": "QVFIUkoxRS1WS00taDhDYkJKTnlfbVdQMFpSdzJXdC1oVXhVMEp0ZAmt4LW1VRjFmaUVDTl93cnJKNUZAUamYtVmdReWl6ZA0hDdTIwNTVvRnMxeVJQUS1VWXRn",
//     "after": "QVFIUkoxRS1WS00taDhDYkJKTnlfbVdQMFpSdzJXdC1oVXhVMEp0ZAmt4LW1VRjFmaUVDTl93cnJKNUZAUamYtVmdReWl6ZA0hDdTIwNTVvRnMxeVJQUS1VWXRn"
// }
