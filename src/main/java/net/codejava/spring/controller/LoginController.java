package net.codejava.spring.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.model.Paste;
import net.codejava.spring.model.User;

@Controller
@SessionAttributes("user")
public class LoginController 
{
	
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Locale locale, Model model) 
	{
		
		return "login";
	
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView handleLogin(@RequestParam String login, @RequestParam String password, ModelAndView model, HttpSession session)
	{
		
		User user = userDAO.get(login);
		
		if(user != null && login.equals(user.getNick()) && password.equals(user.getPassword()))
		{
			Paste newPaste = new Paste();
			model.addObject("paste", newPaste);
			model.setViewName("paste");
			session.setAttribute("user",user);
			model.addObject("user", user);
		}
		else
			model.setViewName("login");
		
		return model;
	}

	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView newUser(ModelAndView model) {
		User newUser = new User();
		model.addObject("user", newUser);
		model.setViewName("RegisterForm");
		return model;
	}
	
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) {
		userDAO.saveOrUpdate(user);		
		return new ModelAndView("redirect:/login");
	}
	
}