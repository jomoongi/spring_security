package kr.co.spring.security.service;


import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import kr.co.spring.security.dao.UserAuthDAO;
import kr.co.spring.security.sec.CustomUserDetails;

@Component("customUserSevice")
public class CustomUserDetailsService implements UserDetailsService {

	private static final Logger logger = Logger.getLogger(CustomUserDetailsService.class);
	
	@Autowired private UserAuthDAO userAuthDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		logger.debug("CustomUserDetailsService - loadUserByUsername");
		
		Map<String, Object> param = userAuthDAO.getUser(username);
		
		CustomUserDetails customUserDetails = new CustomUserDetails();
		
        if(param.get("ts_title")==null) {
            throw new UsernameNotFoundException(username);
        }else {
        	customUserDetails.setUSERNAME(param.get("ts_title").toString());
        	customUserDetails.setPASSWORD("a");
        	if(param.get("ts_title").toString().equals("user")) {
        		customUserDetails.setAUTHORITY("ROLE_USER");
        	}else {
        		customUserDetails.setAUTHORITY("ROLE_ADMIN");
        	}
        	customUserDetails.setENABLED(true);
        }

		
		return customUserDetails;
	}


}
