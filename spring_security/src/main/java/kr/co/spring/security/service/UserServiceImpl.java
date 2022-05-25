package kr.co.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.spring.security.dao.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired private UserDao userDao;
	
	@Override
	public void countFailure(String username) {
		userDao.countFailure(username);
	}

	@Override
	public int checkFailureCount(String username) {
		return userDao.checkFailureCount(username);
	}

	@Override
	public void resetFailureCnt(String username) {
		userDao.resetFailureCnt(username);
	}

}
