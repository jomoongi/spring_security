package kr.co.spring.security.sec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component("loginFailureHandler")
public class LoginFailureHandler implements AuthenticationFailureHandler {

	private static final Logger logger = Logger.getLogger(LoginFailureHandler.class);
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		logger.debug("LoginFailureHandler - onAuthenticationFailure");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String errormsg = exception.getMessage();
		
		logger.debug("username : "  + username);
		logger.debug("password : "  + password);
		logger.debug("errormsg : "  + errormsg);
		
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("errormsg", errormsg);
		
		request.getRequestDispatcher("/spring_security/loginPage?error").forward(request, response);
	}

}
