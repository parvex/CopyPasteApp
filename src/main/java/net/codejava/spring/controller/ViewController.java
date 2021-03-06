package net.codejava.spring.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.PasteDAO;
import net.codejava.spring.model.Paste;
import net.codejava.spring.model.User;



/**
 * This class controlls viewing existing paste
 * @author parvez
 *
 */
@Controller
public class ViewController
{
	@Autowired
	private PasteDAO pasteDAO;
	/**
	 * 
	 * @param path name of file with paste and url to it
	 * @param model current model
	 * @param session session which holds current user
	 * @return 404 error if view not found or view of paste
	 * @throws IOException throws if view not found
	 */
	@RequestMapping(value="/view/{path}", method = RequestMethod.GET)
	public ModelAndView handleView(@PathVariable String path, ModelAndView model, HttpSession session) throws IOException
	{
		Paste paste = pasteDAO.get(path);
		if(paste == null) model.setViewName("404");
		byte[] encoded = Files.readAllBytes(Paths.get("D:/SpringMVC/data/pastes/"+path+".txt"));
		
		
		paste.setPaste(new String(encoded, "UTF-8"));
		model.addObject("paste", paste);
		model.setViewName("view");
		return model;
	}
}
