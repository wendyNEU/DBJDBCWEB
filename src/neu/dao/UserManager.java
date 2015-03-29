package neu.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import neu.model.*;

public class UserManager extends DAO {
	public void createUser(User newUser) {
		String sql = "insert into User (username,password,firstName,lastName,email,dataOfBirth) values (?,?,?,?,?,?)";

		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newUser.getUsername());
			statement.setString(2, newUser.getPassword());
			statement.setString(3, newUser.getFirstName());
			statement.setString(4, newUser.getLastName());
			statement.setString(5, newUser.getEmail());
			statement.setDate(6, newUser.getDateOfBirth());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	public List<User> readAllUsers() {
		List<User> users = new ArrayList<User>();
		String sql = "select * from User";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				User user = new User(results.getString("username"),
						results.getString("password"),
						results.getString("firstName"),
						results.getString("lastName"),
						results.getString("email"),
						results.getDate("dateOfBirth"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return users;
	}

	public User readUser(String username) {
		User user = new User();
		String sql = "select * from User where username=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet results = statement.executeQuery();
			if (results.next()) {
				user = new User(results.getString("username"),
						results.getString("password"),
						results.getString("firstName"),
						results.getString("lastName"),
						results.getString("email"),
						results.getDate("dateOfBirth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return user;
	}

	public void updateUser(String username, User user) {
		String sql = "update User set username=?, password=?,firstName=?,lastName=?,email=?,dataOfBirth=? where username=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setString(5, user.getEmail());
			statement.setDate(6, user.getDateOfBirth());
			statement.setString(7, username);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	public void deleteUser(String username) {
		String sql = "delete from User where username=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}
	
	public List<Movie> getLikes(User user){
		List<Movie> movies = new ArrayList<Movie>();
		String sql = "select * from Movie where Movie.id in (select Comment.movieId fromw Comment where Comment.username=?)";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				Movie movie = new Movie(results.getString("id"),
						results.getString("title"),
						results.getString("posterImage"),
						results.getDate("releaseDate"));
				movies.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return movies;
	}

}
