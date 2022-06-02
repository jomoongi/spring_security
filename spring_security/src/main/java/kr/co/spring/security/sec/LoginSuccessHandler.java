package kr.co.spring.security.sec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import kr.co.spring.security.service.UserService;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger logger = Logger.getLogger(LoginSuccessHandler.class);
	
	@Autowired private UserService userService;
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		logger.debug("LoginSuccessHandler - onAuthenticationSuccess");
		
		String username = request.getParameter("username");
		
		userService.resetFailureCnt(username);
		
		//에러 세션 지우기
		clearAuthenticationAttributes(request);
		
		//RedirectUrl 
		resultRedirectStrategy(request,response,authentication);
		
	}

	public void resultRedirectStrategy(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		
		//처음 접속했던  url을 저장후 그 url로 redirect시켜준다
		if(savedRequest != null) {
			String targetUrl = savedRequest.getRedirectUrl();
			redirectStrategy.sendRedirect(request, response, targetUrl);
		}else {
			redirectStrategy.sendRedirect(request, response, "/main");
		}
		
	}
	
	public void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
}
