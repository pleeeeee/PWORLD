package kr.plee.pl.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import kr.plee.pl.user.service.dto.UserDTO;

public class BaseController {
	
	private HttpServletRequest request;
	
	protected Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	Gson gson = new Gson();
	@SuppressWarnings("deprecation")
	JsonParser jsonParser = new JsonParser();
	
	/**
	 * Object -> JSON 변환
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public JsonObject toJson(Object obj) {
		String jsonStr = gson.toJson(obj);
		
		return jsonParser.parse(jsonStr).getAsJsonObject();
	}
	
	/**
	 * success response
	 * @param response
	 * @param resultJson
	 */
	public void successResponse(HttpServletResponse response, JsonObject resultJson) {
		try {
			response.getWriter().print(resultJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 로그인 직원 정보조회(세션)
	 * @return
	 */
	public UserDTO getSessionUser() {
		HttpSession session = request.getSession();
		
		return (UserDTO) session.getAttribute("SESSION_USER");
	}
	
}
