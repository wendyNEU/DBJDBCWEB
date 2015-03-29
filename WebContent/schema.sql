
CREATE TABLE Actor (
    id VARCHAR(20) NOT NULL,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    dateOfBirth DATE,
    PRIMARY KEY(id)
);

CREATE TABLE User (
    username VARCHAR(20) NOT NULL,
    password VARCHAR(50),
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    email VARCHAR(50),
    dateOfBirth DATE,
    PRIMARY KEY(username)
);

CREATE TABLE Movie (
    id VARCHAR(20) NOT NULL,
    title VARCHAR(50),
    posterImage VARCHAR(50),
    releaseDate DATE,
    PRIMARY KEY(id)
);

CREATE TABLE Comment (
	id VARCHAR(20) NOT NULL,
    comment VARCHAR(50),
    date DATE,
    username VARCHAR(20) NOT NULL,
    movieId VARCHAR(20) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(username) REFERENCES User(username),
    FOREIGN KEY(movieId) REFERENCES Movie(id)
);

CREATE TABLE Cast (
	id VARCHAR(20) NOT NULL,
    characterName VARCHAR(50),
    movieId VARCHAR(20) NOT NULL,
    actorId VARCHAR(20) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(movieId) REFERENCES Movie(id),
    FOREIGN KEY(actorId) REFERENCES Actor(id)
);