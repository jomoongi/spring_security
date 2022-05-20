package kr.co.spring.security.login.ctrl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginErrorCtrl {

	private static final Logger logger = Logger.getLogger(LoginErrorCtrl.class);
	
    @RequestMapping(value="/accessDenied")
    public String accessDeniedPage() throws Exception {
    	
    	logger.debug("권한불충분");
        return "accessDenied";
    }

}
