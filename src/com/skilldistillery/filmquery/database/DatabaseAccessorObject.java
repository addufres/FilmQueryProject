package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "JDBC:mysql://localhost:3306/sdvid";
	private static final String user = "student";
	private static final String pass = "student";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Unable to load database driver...exiting");
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public Film getFilmById(int filmId) throws SQLException {
		Film film = null;
		// CONNECT TO DATABASE
		Connection conn = DriverManager.getConnection(URL, user, pass);
		// SQL TEXT TO QUERY WITH
		String sql = "SELECT * FROM film WHERE id = ?";
		// PASS INTO PREPARESTATEMENT(TEXT)
		PreparedStatement stmt = conn.prepareStatement(sql);
		// DECLARE AND INITIALIZE RESULTSET
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		// PRINT RESULTSET
		if (rs.next() == false && filmId != 0) {
			return film;
		} else {
			rs.beforeFirst();
			while (rs.next()) {
				int id = filmId;
				String title = rs.getString(2);
				String description = rs.getString(3);
				Date releaseYear = rs.getDate(4);
				int languageId = rs.getInt(5);
				int rentalDuration = rs.getInt(6);
				double rentalRate = rs.getDouble(7);
				int length = rs.getInt(8);
				double replacementCost = rs.getDouble(9);
				String rating = rs.getString(10);
				String specialfeatures = rs.getString(11);
				film = new Film(id, title, description, releaseYear, languageId, rentalDuration, rentalRate, length,
						replacementCost, rating, specialfeatures, getActorsByFilmId(id));
			}
		}

		// CLOSE UTILITIES
		rs.close();
		stmt.close();
		conn.close();
		return film;
	}

	@Override
	public Actor getActorById(int actorId) {
		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();
			if (actorResult.next()) {
				actor = new Actor(actorResult.getInt(1), actorResult.getString(2), actorResult.getString(3));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	public List<Film> getFilmsByActorId(int actorId) {
		List<Film> films = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, title, description, release_year, language_id, rental_duration, ";
			sql += " rental_rate, length, replacement_cost, rating, special_features "
					+ " FROM film JOIN film_actor ON film.id = film_actor.film_id " + " WHERE actor_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == false && actorId != 0) {
				return null;
			} else {
				while (rs.next()) {
					int filmId = rs.getInt(1);
					String title = rs.getString(2);
					String desc = rs.getString(3);
					Date releaseYear = rs.getDate(4);
					int langId = rs.getInt(5);
					int rentDur = rs.getInt(6);
					double rate = rs.getDouble(7);
					int length = rs.getInt(8);
					double repCost = rs.getDouble(9);
					String rating = rs.getString(10);
					String features = rs.getString(11);
					Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost,
							rating, features, getActorsByFilmId(filmId));
					films.add(film);
				}
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public List<Actor> getActorsByFilmId(int filmId) {
		List<Actor> cast = new ArrayList<>();
		try {
			// SELECT first_name, id, title, description, release_year, language_id,
			// rental_duration, rental_rate, length, replacement_cost, rating,
			// special_features
			// FROM film JOIN film_actor ON film.id = film_actor.film_id
			// WHERE actor_id = 1;
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "select * from actor a join film_actor fa on fa.actor_id =a.id join film f on f.id = fa.film_id where f.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next() == false && filmId != 0) {
				return null;
			} else {
				while (rs.next()) {
					int id = rs.getInt(1);
					String firstName = rs.getString(2);
					String lastName = rs.getString(3);
					Actor actor = new Actor(id, firstName, lastName);
					cast.add(actor);
				}
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cast;
	}
}
