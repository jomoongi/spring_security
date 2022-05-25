package kr.co.spring.security.sec;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import kr.co.spring.security.service.UserService;

@Component("loginFailureHandler")
public class LoginFailureHandler implements AuthenticationFailureHandler {

	private static final Logger logger = Logger.getLogger(LoginFailureHandler.class);
	@Resource(name = "sbm")
	private Properties sbmProperties;
	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		logger.debug("LoginFailureHandler - onAuthenticationFailure");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String errormsg = exception.getMessage();

		logger.debug("LoginFailureHandler fail username : " + username);
		logger.debug("LoginFailureHandler fail password : " + password);
		logger.debug("LoginFailureHandler errormsg : " + errormsg);

		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("errormsg", "사용자 : " + errormsg + " : id/pw가 맞지않습니다");

		if (exception instanceof BadCredentialsException) {											//비밀번호가 일치하지 않을 때 던지는 예외
			int count = loginFailureCount(username);
			if(count == 3) {
				request.setAttribute("errormsg", count + "번 틀려서 계정 잠겼습니다");
			}else {
				request.setAttribute("errormsg", "비밀번호가 일치하지 않을 때 던지는 예외 " + count + "번 틀렸습니다");
			}
		} else if (exception instanceof InternalAuthenticationServiceException) {					//존재하지 않는 아이디일 때 던지는 예외
			request.setAttribute("errormsg", "존재하지 않는 아이디일 때 던지는 예외");
		} else if (exception instanceof DisabledException) {										//인증 거부 - 계정 비활성화
			request.setAttribute("errormsg", "인증 거부 - 계정 비활성화");
		} else if (exception instanceof CredentialsExpiredException) {								//인증 거부 - 비밀번호 유효기간 만료
			request.setAttribute("errormsg", "인증 거부 - 비밀번호 유효기간 만료");
		}
		
		request.getRequestDispatcher("/loginPage").forward(request, response);
	}

	public int loginFailureCount(String username) {

		userService.countFailure(username);
		int cnt = userService.checkFailureCount(username);
		if (cnt == 3) {
			logger.debug("계정잠금");
			// 추후에 컬럼(계정잠금)에 true/false로 update시켜준다
		}

		return cnt;
	}

}
