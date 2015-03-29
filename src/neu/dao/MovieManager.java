package neu.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import neu.model.*;

public class MovieManager extends DAO {

	public MovieManager() {
		// TODO Auto-generated constructor stub
	}

	public void createMovie(Movie newMovie) {
		String sql = "insert into Movie (id,title,pasterImage,releaseDate) values (?,?,?,?)";

		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newMovie.getId());
			statement.setString(2, newMovie.getTitle());
			statement.setString(3, newMovie.getPosterImage());
			statement.setDate(4, newMovie.getReleaseDate());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	public List<Movie> readAllMovies() {
		List<Movie> movies = new ArrayList<Movie>();
		String sql = "select * from Movie";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
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
			//closeConnection(connection);
		}
		return movies;
	}

	public Movie readMovie(String movieId) {
		Movie movie = new Movie();
		String sql = "select * from Movie where id=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, movieId);
			ResultSet results = statement.executeQuery();
			if (results.next()) {
				movie = new Movie(results.getString("id"),
						results.getString("title"),
						results.getString("posterImage"),
						results.getDate("releaseDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return movie;
	}

	public void updateMovie(String movieId, Movie movie) {
		String sql = "update Movie set title=?, posterImage=?,releaseDate=? where id=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, movie.getTitle());
			statement.setString(2, movie.getPosterImage());
			statement.setDate(3, movie.getReleaseDate());
			statement.setString(4, movieId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	public void deleteMovie(String movieId) {
		String sql = "delete from Movie where id=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, movieId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

}
