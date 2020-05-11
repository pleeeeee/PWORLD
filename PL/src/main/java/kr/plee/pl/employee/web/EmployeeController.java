package kr.plee.pl.employee.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

import kr.plee.pl.common.utils.BaseController;
import kr.plee.pl.user.service.dao.UserMDAO;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends BaseController {

	@Autowired
	private UserMDAO userMDAO;
	
	@RequestMapping("/ids")
    public void getIds(HttpServletRequest request, HttpServletResponse response) {
	
		JsonObject resultJson = new JsonObject();
    	
		
		
    	//resultJson.add("user", toJson(user));
    	
    	successResponse(response, resultJson);
    }
	
}
