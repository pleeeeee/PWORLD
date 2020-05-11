package kr.plee.pl.calendar.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.plee.pl.common.utils.DateUtil;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

	//@Autowired
	//CalendarService calendarService;
	
	@RequestMapping(value = "/week/{year}/{month}/{week}")
    public void calendarWeek(@PathVariable(value = "week") int week,
    		@PathVariable(value = "year", required = false) String year,
    		@PathVariable(value = "month", required = false) String month,
    						   HttpServletResponse response) {
		
		// 0. default(이번주) 
		if ( week == 0 || year.equals("") || month.equals("") ) {
			week = DateUtil.getCurrentWeek();
			year = DateUtil.getCurrentYear();
			month = DateUtil.getCurrentMonth();
		}
		
		Gson gson = new Gson();
		 
		JsonObject resultJson = new JsonObject();
		resultJson.addProperty("week", week);
		resultJson.addProperty("year", year);
		resultJson.addProperty("month", month);
		resultJson.addProperty("weekList", gson.toJson(DateUtil.getWeekDayList(year, month, week)));
        
		System.out.println(resultJson.toString());
		try {
			response.getWriter().print(resultJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} 
    }
	
}
