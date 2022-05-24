package kr.co.spring.security.service;

public interface UserService {

	public void countFailure(String username);
	
	public int checkFailureCount(String username);
}
