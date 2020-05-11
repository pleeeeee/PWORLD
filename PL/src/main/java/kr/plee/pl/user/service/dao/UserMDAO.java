package kr.plee.pl.user.service.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.plee.pl.user.service.dto.UserDTO;

@Mapper
public interface UserMDAO {

	public UserDTO selectUserInfo(String userPwd);
	
}
