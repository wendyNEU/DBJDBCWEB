package neu.model;
public class Cast {
	private String id;
	private String characterName;
	private String movieId;
	private String actorId;

	public Cast(String id, String characterName, String movieId, String actorId) {
		this.id = id;
		this.characterName = characterName;
		this.movieId = movieId;
		this.actorId = actorId;
	}

	public Cast() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getActorId() {
		return actorId;
	}

	public void setActorId(String actorId) {
		this.actorId = actorId;
	}

}
