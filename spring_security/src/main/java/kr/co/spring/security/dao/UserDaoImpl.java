package kr.co.spring.security.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public void countFailure(String username) {
		getSqlSession().update("user.countFailure",username);
	}

	@Override
	public int checkFailureCount(String username) {
		return getSqlSession().selectOne("user.checkFailureCount",username);
	}

}
