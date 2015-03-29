package neu.dao;

import neu.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorManager extends DAO {

	public ActorManager() {
		// TODO Auto-generated constructor stub
	}

	public void createActor(Actor newActor) {
		String sql = "insert into Actor (id,firstName,lastName,dateOfBirth) values (?,?,?,?)";

		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newActor.getId());
			statement.setString(2, newActor.getFirstName());
			statement.setString(3, newActor.getLastName());
			statement.setDate(4, newActor.getDateOfBirth());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	public List<Actor> readAllActors() {
		List<Actor> actors = new ArrayList<Actor>();
		String sql = "select * from Actor";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				Actor actor = new Actor(results.getString("id"),
						results.getString("firstName"),
						results.getString("lastName"),
						results.getDate("dateOfBirth"));
				actors.add(actor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return actors;
	}

	public Actor readActor(String actorId) {
		Actor actor = new Actor();
		String sql = "select * from Actor where id=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, actorId);
			ResultSet results = statement.executeQuery();
			if (results.next()) {
				actor = new Actor(results.getString("id"),
						results.getString("firstName"),
						results.getString("lastName"),
						results.getDate("dateOfBirth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return actor;
	}

	public void updateActor(String actorId, Actor actor) {
		String sql = "update Actor set firstName=?, lastName=?,dateOfBirth=? where id=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, actor.getFirstName());
			statement.setString(2, actor.getLastName());
			statement.setDate(3, actor.getDateOfBirth());
			statement.setString(4, actorId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	public void deleteActor(String actorId) {
		String sql = "delete from Actor where id=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, actorId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

}
