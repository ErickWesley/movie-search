CREATE TABLE movie (
	id serial PRIMARY KEY,
	title varchar(100),
	date_create varchar(4),
	imdbRating varchar(3),
	plot varchar(550),
	poster varchar(350)
);