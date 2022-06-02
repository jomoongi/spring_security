package kr.co.spring.security.sec;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import kr.co.spring.security.common.Common;
import kr.co.spring.security.service.CustomUserDetailsService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static final Logger logger = Logger.getLogger(CustomAuthenticationProvider.class);

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private Common common;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		logger.debug("CustomAuthenticationProvider - authenticate");

		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();

		logger.debug("username : " + username);
		logger.debug("password : " + password);

		//loadUserByUsername를 구태여 쓸필요없이 일반적으로 db연동해서 map으로 꺼내와도된다
		//대신 권한을 줄때 spring-security.xml에서 설정한 hasAnyRole('ROLE_MEMBER','ROLE_ADMIN') ROLE_MEMBER를 보내줘야 해당 페이지 접근가능
		CustomUserDetails customUserDetails = (CustomUserDetails) customUserDetailsService.loadUserByUsername(username);
		
		if (!password.equals(customUserDetails.getPassword().toString())) {
			throw new BadCredentialsException(username);
		}
		
		return new UsernamePasswordAuthenticationToken(username,password,customUserDetails.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
