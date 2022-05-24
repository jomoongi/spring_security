package kr.co.spring.security.login.ctrl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginCtrl {

	private static final Logger logger = Logger.getLogger(LoginCtrl.class);
	
	@RequestMapping(value = "/loginPage")
	public String loginPage() {
		
		logger.debug("loginPage 입니다");
		
		return "login";
	}
	
    @RequestMapping(value="/accessDenied")
    public String accessDeniedPage() throws Exception {
    	
    	logger.debug("권한불충분");
    	
        return "accessDenied";
    }
}
