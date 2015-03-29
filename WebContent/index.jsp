<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="neu.dao.*,neu.model.*,java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>

	<%
		MovieManager movieDAO = new MovieManager();

		List<Movie> movies = movieDAO.readAllMovies();

		for (Movie movie : movies) {
			out.println("Id:" + movie.getId() + ";\tPosterImage:"
					+ movie.getPosterImage() + ";\tTitle:"
					+ movie.getTitle() + ";\tRelease Date:"
					+ movie.getReleaseDate());
		}
	%>
</body>
</html>