package kr.co.spring.security.ctrl;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.spring.security.common.Common;
import kr.co.spring.security.sec.CustomUserDetails;

@Controller
public class MainCtrl {
	
	private static final Logger logger = Logger.getLogger(MainCtrl.class);
	
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main(ModelMap modelMap)  {
		
		logger.debug("mainPage 입니다");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();

		String name = "";
		if(principal != null) {
			name = auth.getName();
			logger.debug(name);
		}
		modelMap.addAttribute("name", name);
		
		return "mainPage";
	}
	
	@RequestMapping(value = "member", method = RequestMethod.GET)
	public ModelAndView member()  {
	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member");
		
		return modelAndView;
	}
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public ModelAndView user()  {
	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user");
		
		return modelAndView;
	}
	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public ModelAndView admin()  {
	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin");
		
		return modelAndView;
	}
}
