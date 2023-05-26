package com.in28minutes.springbootproject.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userName")
public class WelcomeController {

	/*
	 * private Logger logger = LoggerFactory.getLogger(getClass());
	 * 
	 * private AuthenticationService authService;
	 * 
	 * public LoginController(AuthenticationService authService) { super();
	 * this.authService = authService; }
	 */

	/*
	 * @RequestMapping("login") public String gotToLoginPage(@RequestParam String
	 * name, ModelMap model) { logger.debug("Request Param is {}", name);
	 * model.put("inName", name); return "login"; }
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("userName", getLoggedInUserName());

		return "welcome";
	}

	private String getLoggedInUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	/*
	 * @RequestMapping(value = "login-page", method = RequestMethod.POST) public
	 * String goToWelcomePage(@RequestParam String Name, @RequestParam String
	 * Password, ModelMap model) {
	 * 
	 * model.put("userName", Name); model.put("userPassword", Password); if
	 * (authService.authenticateUser(Name, Password)) { return "welcome"; } else {
	 * model.put("ErrorMessage", "Invalid Credential. Please Try Again"); return
	 * "login"; }
	 * 
	 * }
	 */

}
