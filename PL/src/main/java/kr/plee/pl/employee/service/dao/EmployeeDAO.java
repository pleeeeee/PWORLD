package kr.plee.pl.employee.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.plee.pl.employee.service.dto.EmployeeDTO;

@Mapper
public interface EmployeeDAO {

	/** ���������ȸ */
	public List<EmployeeDTO> selectEmployeeIds();

}