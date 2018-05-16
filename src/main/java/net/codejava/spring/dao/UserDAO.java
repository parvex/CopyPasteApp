package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.User;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface UserDAO {
	
	public void saveOrUpdate(User contact);
	
	public void delete(String nick);
	
	public User get(String nick);
	
	public List<User> list();
	
}
