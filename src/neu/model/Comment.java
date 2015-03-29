package neu.model;
import java.sql.Date;

public class Comment {
	private String id;
	private String comment;
	private Date date;
	private String username;
	private String movieId;

	public Comment(String id, String comment, Date date, String username,
			String movieId) {
		this.id = id;
		this.comment = comment;
		this.date = date;
		this.username = username;
		this.movieId = movieId;
	}

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
}
