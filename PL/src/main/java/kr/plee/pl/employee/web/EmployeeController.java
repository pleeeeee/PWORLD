package kr.plee.pl.employee.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

import kr.plee.pl.common.utils.BaseController;
import kr.plee.pl.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends BaseController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/ids")
    public void getEmployeeIds(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		JsonObject resultJson = new JsonObject();
    	
		logger.debug("@@ serverName: {}", request.getServerName());
		// 
		
		//직원목록조회
		//List<EmployeeDTO> empList = employeeService.getEmployeeIds();
		
    	//resultJson.add("empList", toJson(empList));
    	
    	successResponse(response, resultJson);
    }
	
}
