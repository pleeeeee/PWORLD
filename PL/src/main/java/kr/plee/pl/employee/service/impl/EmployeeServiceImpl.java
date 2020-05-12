package kr.plee.pl.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.plee.pl.employee.service.EmployeeService;
import kr.plee.pl.employee.service.dao.EmployeeDAO;
import kr.plee.pl.employee.service.dto.EmployeeDTO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public List<EmployeeDTO> getEmployeeIds() throws Exception {
		return employeeDAO.selectEmployeeIds();
	}

}
