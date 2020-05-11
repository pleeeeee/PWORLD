package kr.plee.pl.login.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

import kr.plee.pl.common.utils.BaseController;
import kr.plee.pl.user.service.dao.UserMDAO;
import kr.plee.pl.user.service.dto.UserDTO;

@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

	@Autowired
	private UserMDAO userMDAO;
	
	@RequestMapping("/{userPwd}")
    public void calendarWeek(@PathVariable(value = "userPwd") final String userPwd, HttpServletRequest request, HttpServletResponse response) {
	
		JsonObject resultJson = new JsonObject();
    	
    	UserDTO user = userMDAO.selectUserInfo(userPwd);
    	System.out.print(user.toString());

    	resultJson.add("user", toJson(user));
    	
    	// make session
        HttpSession session = request.getSession(true);
        session.setAttribute("SESSION_USER", user);
    	
    	successResponse(response, resultJson);
    }
	
}
