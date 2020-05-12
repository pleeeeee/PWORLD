package kr.plee.pl.employee.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@SuppressWarnings("unused")
public class EmployeeDTO {

	private String empId = "";
	private String gymCd = "";
	private String pwd = "";
	private String empNm = "";
}
