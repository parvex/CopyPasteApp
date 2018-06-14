package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.User;

/**
 * Defines DAO operations for the user model
 */
public interface UserDAO {
	
	
	/**
	 * Saves or updates user in DB
	 * @param paste paste to save
	 */
	public void saveOrUpdate(User contact);
	/**
	 * Deletes user from DB
	 * @param pasteId
	 */
	public void delete(String nick);
	/**
	 * Gets user of given nick from DB
	 * @param pasteId
	 * @return
	 */
	public User get(String nick);
	/**
	 * Returns list of users
	 * @param user_id
	 * @return
	 */
	public List<User> list();
	
}
