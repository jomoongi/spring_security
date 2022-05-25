package kr.co.spring.security.dao;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Component
public class UserAuthDAO extends SqlSessionDaoSupport{

	public Map<String, Object> getUser(String username) {
		return getSqlSession().selectOne("user.getUser", username);
	}
}
