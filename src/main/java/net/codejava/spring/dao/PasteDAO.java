package net.codejava.spring.dao;


/**
 * Defines DAO operations for the paste model
 */

import java.util.List;

import net.codejava.spring.model.Paste;

public interface PasteDAO
{
	/**
	 * Saves or updates paste in DB
	 * @param paste paste to save
	 */
	public void saveOrUpdate(Paste paste);
	/**
	 * Deletes paste from DB
	 * @param pasteId
	 */
	public void delete(int pasteId);
	/**
	 * Gets paste of given id from DB
	 * @param pasteId
	 * @return
	 */
	public Paste get(int pasteId);
	
	/**
	 * Returns list of pastes of given user
	 * @param user_id
	 * @return
	 */
	public List<Paste> list(int user_id);	
	/**
	 * Gets Paste of given path
	 * @param path
	 * @return
	 */
	public Paste get(String path);
}
