package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.model.Paste;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the PasteDAO interface.
 *
 */
public class PasteDAOImpl implements PasteDAO {

	private JdbcTemplate jdbcTemplate;
	
	public PasteDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Paste paste) {
		if (paste.getId() > 0) {
			// update
			String sql = "UPDATE pastes SET title=?, author=?, path=?, "
						+ "syntax=?, user_id=? WHERE paste_id=?";
			jdbcTemplate.update(sql, paste.getTitle(), paste.getAuthor(),
					paste.getPath(), paste.isSyntax(), paste.getUser_id(), paste.getId());
		} else {
			// insert
			String sql = "INSERT INTO pastes (title, author, path, syntax, user_id)"
						+ " VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql,  paste.getTitle(), paste.getAuthor(),
					paste.getPath(), paste.isSyntax(), paste.getUser_id());
		}
		
	}

	@Override
	public void delete(int pasteId) {
		String sql = "DELETE FROM pastes WHERE paste_id=?";
		jdbcTemplate.update(sql, pasteId);
	}

	@Override
	public List<Paste> list(int user_id) {
		String sql = "SELECT * FROM pastes where user_id=" +user_id;
		List<Paste> listPaste = jdbcTemplate.query(sql, new RowMapper<Paste>() {

			@Override
			public Paste mapRow(ResultSet rs, int rowNum) throws SQLException {
				Paste aPaste = new Paste();
	
				aPaste.setId(rs.getInt("paste_id"));
				aPaste.setTitle(rs.getString("title"));
				aPaste.setAuthor(rs.getString("author"));
				aPaste.setPath(rs.getString("path"));
				aPaste.setSyntax(rs.getBoolean("syntax"));
				aPaste.setUser_id(rs.getInt("user_id"));
				
				return aPaste;
			}
			
		});
		
		return listPaste;
	}

	@Override
	public Paste get(int pasteId) {
		String sql = "SELECT * FROM pastes WHERE paste_id=" + pasteId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Paste>() {

			@Override
			public Paste extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Paste paste = new Paste();
					paste.setId(rs.getInt("paste_id"));
					paste.setTitle(rs.getString("title"));
					paste.setAuthor(rs.getString("author"));
					paste.setPath(rs.getString("path"));
					paste.setSyntax(rs.getBoolean("syntax"));
					paste.setUser_id(rs.getInt("user_id"));
					return paste;
				}
				
				return null;
			}
			
		});
	}
	
	
	@Override
	public Paste get(String path) {
		String sql = "SELECT * FROM pastes WHERE path=" +"'" +path + "'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Paste>() {

			@Override
			public Paste extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Paste paste = new Paste();
					paste.setId(rs.getInt("paste_id"));
					paste.setTitle(rs.getString("title"));
					paste.setAuthor(rs.getString("author"));
					paste.setPath(rs.getString("path"));
					paste.setSyntax(rs.getBoolean("syntax"));
					paste.setUser_id(rs.getInt("user_id"));
					return paste;
				}
				
				return null;
			}
			
		});
	}

}
