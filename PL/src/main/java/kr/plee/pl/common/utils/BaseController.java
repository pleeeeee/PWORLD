package kr.plee.pl.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.plee.pl.user.service.dto.UserDTO;

public class BaseController {
	
	private HttpServletRequest request;
	
	Gson gson = new Gson();
	@SuppressWarnings("deprecation")
	JsonParser jsonParser = new JsonParser();
	
	@SuppressWarnings("deprecation")
	public JsonObject toJson(Object obj) {
		String jsonStr = gson.toJson(obj);
		
		return jsonParser.parse(jsonStr).getAsJsonObject();
	}
	
	public void successResponse(HttpServletResponse response, JsonObject resultJson) {
		try {
			response.getWriter().print(resultJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public UserDTO getSessionUser() {
		HttpSession session = request.getSession();
		
		return (UserDTO) session.getAttribute("SESSION_USER");
	}
	
}
