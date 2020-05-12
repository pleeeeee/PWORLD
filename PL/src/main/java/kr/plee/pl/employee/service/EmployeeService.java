package kr.plee.pl.employee.service;

import java.util.List;

import kr.plee.pl.employee.service.dto.EmployeeDTO;

/**
 * 직원 서비스
 */
public interface EmployeeService {

	public List<EmployeeDTO> getEmployeeIds() throws Exception;

}
