package kr.plee.pl.employee.service;

import java.util.List;

import kr.plee.pl.employee.service.dto.EmployeeDTO;

/**
 * ���� ����
 */
public interface EmployeeService {

	public List<EmployeeDTO> getEmployeeIds() throws Exception;

}