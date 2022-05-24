package kr.co.spring.security.dao;

public interface UserDao {

	public void countFailure(String username);
	
	public int checkFailureCount(String username);
}
