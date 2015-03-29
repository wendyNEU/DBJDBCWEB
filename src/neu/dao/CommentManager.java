package neu.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import neu.model.*;

public class CommentManager extends DAO {

	public CommentManager() {
		// TODO Auto-generated constructor stub
	}

	public void createComment(Comment newComment) {
		String sql = "insert into Comment (id,comment,date,username,movieId) values (?,?,?,?,?)";

		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newComment.getId());
			statement.setString(2, newComment.getComment());
			statement.setDate(3, newComment.getDate());
			statement.setString(4, newComment.getUsername());
			statement.setString(5, newComment.getMovieId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	public List<Comment> readAllComments() {
		List<Comment> comments = new ArrayList<Comment>();
		String sql = "select * from Comment";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				Comment comment = new Comment(results.getString("id"),
						results.getString("comment"), results.getDate("date"),
						results.getString("username"),
						results.getString("movieId"));
				comments.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return comments;
	}

	public List<Comment> readAllCommentsForUsername(String username) {
		List<Comment> comments = new ArrayList<Comment>();
		String sql = "select * from Comment where username = ?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				Comment comment = new Comment(results.getString("id"),
						results.getString("comment"), results.getDate("date"),
						results.getString("username"),
						results.getString("movieId"));
				comments.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return comments;
	}

	public List<Comment> readAllCommentsForMovie(String movieId) {
		List<Comment> comments = new ArrayList<Comment>();
		String sql = "select * from Comment where movieId = ?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, movieId);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				Comment comment = new Comment(results.getString("id"),
						results.getString("comment"), results.getDate("date"),
						results.getString("username"),
						results.getString("movieId"));
				comments.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return comments;
	}

	public Comment readCommentForId(String commentId) {
		Comment comment = new Comment();
		String sql = "select * from User where id=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, commentId);
			ResultSet results = statement.executeQuery();
			if (results.next()) {
				comment = new Comment(results.getString("id"),
						results.getString("comment"), results.getDate("date"),
						results.getString("username"),
						results.getString("movieId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return comment;
	}

	public void updateComment(String commentId, String newComment) {
		String sql = "update Comment set comment=?, date=GETDATE() where id=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newComment);
			statement.setString(2, commentId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	public void deleteComment(String commentId) {
		String sql = "delete from Comment where id=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, commentId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

}
