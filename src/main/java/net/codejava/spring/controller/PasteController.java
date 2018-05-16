package net.codejava.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.PasteDAO;
import net.codejava.spring.model.Paste;
import net.codejava.spring.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
@Controller
public class PasteController
{
	@Autowired
	private PasteDAO pasteDAO;
	
	
	
	@RequestMapping(value="/paste", method = RequestMethod.GET)
	public ModelAndView showPaste(ModelAndView model, HttpSession session) throws IOException{

		User user = (User) session.getAttribute("user");
		if(user == null) 
		{
			model.setViewName("redirect:login");
			return model;
		}
		model.addObject("paste", new Paste());
		model.setViewName("paste");
		
		return model;
	}
	
	
	@RequestMapping(value = "/savePaste", method = RequestMethod.POST)
	public ModelAndView savePaste(@ModelAttribute Paste paste, HttpSession session) throws IOException {
		
		
		User user = (User) session.getAttribute("user");
		if(user == null || paste == null) 
			return new ModelAndView("redirect:login");
		String path = null;
		if(paste.getPath().equals(""))
		{
			for(int i =0; i < 10; ++i)
			{
				path = RandomStringUtils.randomAlphanumeric(100); //generate random path
				if(pasteDAO.get(path) == null)
					break;
			}
			paste.setPath(path);
		}
		else
		{
			path = paste.getPath();
			
		}
		File file = new File("D:/SpringMVC/data/pastes/"+path+".txt");
		PrintWriter out = new PrintWriter(file);
		out.print(paste.getPaste());
		out.close();
		paste.setUser_id(user.getId());
		
		
		pasteDAO.saveOrUpdate(paste);
		
		return new ModelAndView("redirect:view/"+path);
	}
}
