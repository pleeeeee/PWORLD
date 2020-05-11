package kr.plee.pl.user.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class UserDTO {

	private String userId;
	private String userName;
	private String kakaoToken;
	private String userPwd;

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", kakaoToken=" + kakaoToken + ", userPwd="
				+ userPwd + "]";
	}
	
}
