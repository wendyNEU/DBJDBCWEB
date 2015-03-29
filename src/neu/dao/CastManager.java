package neu.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import neu.model.*;

public class CastManager extends DAO {

	public CastManager() {
		// TODO Auto-generated constructor stub
	}

	public void createCast(Cast newCast) {
		String sql = "insert into Cast (id,characterName,movieId,actorId) values (?,?,?,?)";

		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newCast.getId());
			statement.setString(2, newCast.getCharacterName());
			statement.setString(3, newCast.getMovieId());
			statement.setString(4, newCast.getActorId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	public List<Cast> readAllCast() {
		List<Cast> casts = new ArrayList<Cast>();
		String sql = "select * from Cast";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				Cast cast = new Cast(results.getString("id"),
						results.getString("characterName"),
						results.getString("movieId"),
						results.getString("actorId"));
				casts.add(cast);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return casts;
	}

	public List<Cast> readAllCastForActor(String actorId) {
		List<Cast> casts = new ArrayList<Cast>();
		String sql = "select * from Cast where actorId=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, actorId);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				Cast cast = new Cast(results.getString("id"),
						results.getString("characterName"),
						results.getString("movieId"),
						results.getString("actorId"));
				casts.add(cast);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return casts;
	}

	public List<Cast> readAllCastForMovie(String movieId) {
		List<Cast> casts = new ArrayList<Cast>();
		String sql = "select * from Cast where movieId=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, movieId);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				Cast cast = new Cast(results.getString("id"),
						results.getString("characterName"),
						results.getString("movieId"),
						results.getString("actorId"));
				casts.add(cast);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return casts;
	}

	public Cast readCastForId(String castId) {
		Cast cast = new Cast();
		String sql = "select * from Cast where id=? LIMIT 1";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, castId);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				cast = new Cast(results.getString("id"),
						results.getString("characterName"),
						results.getString("movieId"),
						results.getString("actorId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return cast;
	}

	public void updateCast(String castId, Cast newCast) {
		String sql = "update Cast set characterName=?, movieId=?,actorId=? where id=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newCast.getCharacterName());
			statement.setString(2, newCast.getMovieId());
			statement.setString(3, newCast.getActorId());
			statement.setString(4, castId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	public void deleteCast(String castId) {
		String sql = "delete from Cast where id=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, castId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

}
