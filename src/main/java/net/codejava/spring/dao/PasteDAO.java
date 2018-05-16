package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Paste;

public interface PasteDAO
{
	public void saveOrUpdate(Paste paste);
	
	public void delete(int pasteId);
	
	public Paste get(int pasteId);
	
	public List<Paste> list(int user_id);	
	public Paste get(String path);
}
