package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
	public Film getFilmById(int filmId) throws SQLException;

	public Actor getActorById(int actorId);

	public List<Actor> getActorsByFilmId(int filmId);
	
	public List<Film> getFilmsByActorId(int actorId);

	public List<Film> getFilmBySearch(String word) throws SQLException;

	public String getLanguage(Film film);
}
