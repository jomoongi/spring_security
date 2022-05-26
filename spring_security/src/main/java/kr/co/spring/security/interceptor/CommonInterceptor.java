package kr.co.spring.security.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = Logger.getLogger(CommonInterceptor.class);
	
	/**
	 * controller 호출되기전
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
//		logger.debug("============================== START ==============================");
//		logger.info(" Class       \t:  " + handler.getClass());
//		logger.info(" Request URI \t:  " + request.getRequestURI());
//		logger.info(" Servlet URI \t:  " + request.getServletPath());
		
		Enumeration<String> paramNames = request.getParameterNames();
		
		while (paramNames.hasMoreElements()) {
			String key = (String) paramNames.nextElement();  
			String value = request.getParameter(key);
			logger.info("# RequestParameter: " + key + "=" + value + "");
		}
		
//		logger.info("==================================================================== ");

		return super.preHandle(request, response, handler);
	}

	/**
	 * controller 처리 이후 작업 / 화면을 처리하기전 작업
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		logger.debug("postHandle");
	}

	/**
	 * 화면처리까지 완료된 이후
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
        if (logger.isDebugEnabled()) {
//        	logger.debug("============================== END ==============================\n");
        }
		
	}

}
