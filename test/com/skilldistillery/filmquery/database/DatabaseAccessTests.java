package com.skilldistillery.filmquery.database;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

class DatabaseAccessTests {
	private DatabaseAccessor db;

	@BeforeEach
	void setUp() throws Exception {
		db = new DatabaseAccessorObject();
	}

	@AfterEach
	void tearDown() throws Exception {
		db = null;
	}

	@Test
	void test_getFilmById_with_invalid_id_returns_null() throws SQLException {
		Film f = db.getFilmById(-42);
		assertNull(f);
	}

	@Test
	void test_getActorById_with_invalid_id_returns_null() throws SQLException {
		Film f = db.getFilmById(-42);
		assertNull(f);
	}

	@Test
	void test_getActorsByFilmId_with_invalid_id_returns_null() throws SQLException {
		List<Actor> f = db.getActorsByFilmId(-42);
		assertNull(f);
	}

	@Test
	void test_getFilmsByActorId_with_invalid_id_returns_null() throws SQLException {
		List<Film> f = db.getFilmsByActorId(-42);
		assertNull(f);
	}

}
