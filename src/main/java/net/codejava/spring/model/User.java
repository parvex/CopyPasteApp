package net.codejava.spring.model;

public class User
{
	private int id;
	private String nick;
	private String password;
	private String email;
	
	public User()
	{
	}
	
	public User(String nick, String password, String email)
	{
		this.nick = nick;
		this.password = password;
		this.email = email;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getNick()
	{
		return nick;
	}
	public void setNick(String nick)
	{
		this.nick = nick;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	
}
