package net.codejava.spring.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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


/**
 * This class controls operations on profile - show profile,delete paste, edit paste
 * @author parvez
 * 
 *
 */

@Controller
public class ProfileController
{
	@Autowired
	private PasteDAO pasteDAO;

	/**
	 * 
	 * @param model current model will hold list of pastes
	 * @param session holds current user object
	 * @return profile.jsp which shows list of pastes
	 */
	@RequestMapping(value="/profile", method = RequestMethod.GET)
	public ModelAndView showProfile(ModelAndView model, HttpSession session){

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
	
	
	/**
	 * 
	 * @param request request from which i get id parameter of paste to delete
	 * @return profile.jsp
	 */
	@RequestMapping(value = "/deletePaste", method = RequestMethod.GET)
	public ModelAndView deletePaste(HttpServletRequest request) {
		int pasteId = Integer.parseInt(request.getParameter("id"));
		
		File file = new File("D:/SpringMVC/data/pastes/"+pasteDAO.get(pasteId).getPath()+".txt");
		file.delete();
		pasteDAO.delete(pasteId);
		return new ModelAndView("redirect:/profile");
	}
	
	/**
	 * 
	 * @param request request request from which i get id parameter of paste to edit
	 * @param session current user object, only owner of paste can edit it
	 * @return paste.jsp to edit or login if wrong user
	 * @throws IOException when failed to read paste
	 */
	@RequestMapping(value = "/editPaste", method = RequestMethod.GET)
	public ModelAndView editPaste(HttpServletRequest request, HttpSession session) throws IOException {
		
		User user = (User) session.getAttribute("user");
		int pasteId = Integer.parseInt(request.getParameter("id"));
		Paste paste = pasteDAO.get(pasteId);
		byte[] encoded = Files.readAllBytes(Paths.get("D:/SpringMVC/data/pastes/"+paste.getPath()+".txt"));
		paste.setPaste(new String(encoded, "UTF-8"));
		if(user == null || paste.getUser_id() != user.getId()) return new ModelAndView("redirect:login");
		ModelAndView model = new ModelAndView("paste");
		model.addObject("paste", paste);
		
		return model;
	}
	
	/**
	 * 
	 * @param session holds current user
	 * @return login.jsp
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView deletePaste(HttpSession session) {
		
		session.setAttribute("user", null);
		return new ModelAndView("redirect:/login");
	}
	
}
