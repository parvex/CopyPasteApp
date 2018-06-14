	package net.codejava.spring.dao;
	
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.List;
	
	import javax.sql.DataSource;
	
	import net.codejava.spring.model.User;
	
	import org.springframework.dao.DataAccessException;
	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.jdbc.core.ResultSetExtractor;
	import org.springframework.jdbc.core.RowMapper;
	
	/**
	 * An implementation of the UserDAO interface.
	 * @author www.codejava.net
	 *
	 */
	public class UserDAOImpl implements UserDAO {
	
		private JdbcTemplate jdbcTemplate;
		
		public UserDAOImpl(DataSource dataSource) {
			jdbcTemplate = new JdbcTemplate(dataSource);
		}
	
		@Override
		public void saveOrUpdate(User user) {
			if (user.getId() > 0) {
				// update
				String sql = "UPDATE users SET nick=?, password=?, email=?, "
							 + "WHERE nick=?";
				jdbcTemplate.update(sql, user.getNick(), user.getPassword(),
						user.getEmail(), user.getNick());
			} else {
				// insert
				String sql = "INSERT INTO users (nick, password, email)"
							+ " VALUES (?, ?, ?)";
				jdbcTemplate.update(sql, user.getNick(), user.getPassword(),
						user.getEmail()); 
			}
			
		}
	
		@Override
		public void delete(String nick) {
			String sql = "DELETE FROM users WHERE nick=?";
			jdbcTemplate.update(sql, nick);
		}
	
		@Override
		public List<User> list() {
			String sql = "SELECT * FROM users";
			List<User> listUser = jdbcTemplate.query(sql, new RowMapper<User>() {
	
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User aUser = new User();
		
					aUser.setId(rs.getInt("user_id"));
					aUser.setNick(rs.getString("name"));
					aUser.setPassword(rs.getString("email"));
					aUser.setEmail(rs.getString("address"));
					
					
					return aUser;
				}
				
			});
			
			return listUser;
		}
	
		@Override
		public User get(String nick) {
			String sql = "SELECT * FROM users WHERE nick='" + nick+"'";
			return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {
	
				@Override
				public User extractData(ResultSet rs) throws SQLException,
						DataAccessException {
					if (rs.next()) {
						User user = new User();
						user.setId(rs.getInt("user_id"));
						user.setNick(rs.getString("nick"));
						user.setPassword(rs.getString("password"));
						user.setEmail(rs.getString("email"));
						return user;
					}
					
					return null;
				}
			});
		}
	
	}
