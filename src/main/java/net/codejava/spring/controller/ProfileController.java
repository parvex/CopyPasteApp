package net.codejava.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.PasteDAO;
import net.codejava.spring.model.Paste;
import net.codejava.spring.model.User;

@Controller
public class ProfileController
{
	@Autowired
	private PasteDAO pasteDAO;

	@RequestMapping(value="/profile", method = RequestMethod.GET)
	public ModelAndView showProfile(ModelAndView model, HttpSession session) throws IOException{

		User user = (User) session.getAttribute("user");
		if(user == null) 
		{
			model.setViewName("redirect:login");
			return model;
		}
		List<Paste> listPaste = pasteDAO.list(user.getId());
		model.addObject("listPaste", listPaste);
		model.setViewName("profile");
		
		return model;
	}
	
	@RequestMapping(value = "/deletePaste", method = RequestMethod.GET)
	public ModelAndView deletePaste(HttpServletRequest request) {
		int pasteId = Integer.parseInt(request.getParameter("id"));
		
		File file = new File("D:/SpringMVC/data/pastes/"+pasteDAO.get(pasteId).getPath()+".txt");
		file.delete();
		pasteDAO.delete(pasteId);
		return new ModelAndView("redirect:/profile");
	}
	
	@RequestMapping(value = "/editPaste", method = RequestMethod.GET)
	public ModelAndView editPaste(HttpServletRequest request, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		int pasteId = Integer.parseInt(request.getParameter("id"));
		Paste paste = pasteDAO.get(pasteId);
		if(user == null || paste.getUser_id() != user.getId()) return new ModelAndView("redirect:login");
		ModelAndView model = new ModelAndView("paste");
		model.addObject("paste", paste);
		
		return model;
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView deletePaste(HttpServletRequest request, HttpSession session) {
		
		session.setAttribute("user", null);
		return new ModelAndView("redirect:/login");
	}
	
}
