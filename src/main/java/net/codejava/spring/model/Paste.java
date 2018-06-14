package net.codejava.spring.model;
/**
 * Model class of Paste
 * @author parvez
 *
 */

public class Paste
{
	private int id;
	private int user_id;
	private String title;
	private String author;
	private boolean syntax;
	private String path;
	private String paste;
	public String getPaste()
	{
		return paste;
	}
	public void setPaste(String paste)
	{
		this.paste = paste;
	}
	public Paste()
	{
		
	}
	public Paste(int user_id, String title, String author, boolean syntax, String path, String paste)
	{
		this.user_id = user_id;
		this.title = title;
		this.author = author;
		this.syntax = syntax;
		this.path = path;
		this.paste = paste;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getUser_id()
	{
		return user_id;
	}
	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public boolean isSyntax()
	{
		return syntax;
	}
	public void setSyntax(boolean syntax)
	{
		this.syntax = syntax;
	}
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}

	
}
