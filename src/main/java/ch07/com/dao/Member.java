package ch07.com.dao;

import java.util.regex.Pattern;

public class Member {
	public static final String pattern1 = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
	public static final String pattern2 = "(02|010)-\\d{3,4}-\\d{4}";
	private String email;
	private String phoneNum;
	
	public boolean checkEamil() {
		if (Pattern.matches(pattern1, email)) {
			return true;
		}
		return false;
	}
	
	public boolean checkPhoneNum() {
		if (Pattern.matches(pattern2, phoneNum)) {
			return true;
		}
		return false;
	}
	
	public String result() {
		String result;
		if(checkEamil() && checkPhoneNum()) {
			result = "환영합니다.";
			return result;
		}
		result = "유효성 검사에 통과하지 못했습니다.";
		return result;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	
	
	
	
}
