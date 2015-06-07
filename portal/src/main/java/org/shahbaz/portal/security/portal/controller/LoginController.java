package org.shahbaz.portal.security.portal.controller;

import org.shahbaz.portal.security.portal.utils.UIConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(Model model) {

		return UIConstants.LOGIN_PAGE;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String getSignUpPage(Model model) {

		return UIConstants.SIGN_UP_PAGE;
	}
}
