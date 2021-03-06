package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		// app.test();
		app.launch();
	}

	private void test() throws SQLException {
		// Film film = db.getFilmById(1);
		// System.out.println(film);
		//
		// Actor actor = db.getActorById(1);
		// System.out.println(actor);
		//
		// List<Film> films = db.getFilmsByActorId(1);
		// System.out.println(films);
		//
		// List<Actor> cast = db.getActorsByFilmId(1);
		// System.out.println(cast);
		//
		// List<Film> filmSearch = db.getFilmBySearch("per");
		// System.out.println(filmSearch);

	}

	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) throws SQLException {
		int choice = -1;
		OUTER: while (choice != 3) {
			System.out.println("\n\nPlease make a selection: 1, 2 , or 3\n1. Look up a film by its id.\n"
					+ "2. Look up a film by a search keyword.\n" + "3. Exit the application.");
			
			choice = input.nextInt();
			input.nextLine();
			switch (choice) {
			case 1:
				// If the user looks up a film by id, they are prompted to enter the film id. If
				// the film is not found,
				// they see a message saying so. If the film is found, its title, year, rating,
				// and description are displayed.
				System.out.println("Enter an ID for a film: ");
				int filmId = input.nextInt();
				Film film = db.getFilmById(filmId);
				if (filmId > 0) {
					printFilm(film);
					choice = -1;
					INNER: while (choice != 1) {
						System.out.println("\t\t\n\nPlease make another selection: 1, or 2\n1. Return to main menu.\n"
								+ "2. View all film details.");
						choice = input.nextInt();
						switch (choice) {
						case 1:
							break INNER;
						case 2:
							printAllFields(film);
							break INNER;
						default:
							break;
						}
					}
					break;
				} else {
					System.out.println("Film Not Found!");
					break;
				}
			case 2:
				// If the user looks up a film by search keyword, they are prompted to enter it.
				// If no matching
				// films are found, they see a message saying so. Otherwise, they see a list of
				// films for which the search
				// term was found anywhere in the title or description, with each film displayed
				// exactly as it is for User Story 2.
				System.out.println("Enter your search word: ");
				String word = input.nextLine();
				List<Film> films = db.getFilmBySearch(word);
				if (word.length() > 0) {
					for (Film f : films) {
						printFilm(f);
					}
					choice = -1;
					INNER: while (choice != 1) {
						System.out.println("\t\t\n\nPlease make another selection: 1, or 2\n1. Return to main menu.\n"
								+ "2. View all film details.");
						choice = input.nextInt();
						switch (choice) {
						case 1:
							break INNER;
						case 2:
							
							for(Film f : films)
							printAllFields(f);
							break INNER;
						default:
							break;
						}
					}
					break;
				} else {
					System.out.println("Film Not Found!");
					break;
				}
			case 3:
				System.out.println("Thank you Goodbye.");
				break OUTER;
			default:
				System.out.println("Incorrect choice make another selection.");
				break;
			}

		}

	}

	private void printFilm(Film film) {
		System.out.println("Title = " + film.getTitle() + "\nYear = " + film.getReleaseYear() + "\nRating = "
				+ film.getRating() + "\nDescription = " + film.getDescription() + "\n Language = "
				+ db.getLanguage(film) + "\n Cast = " + db.getActorsByFilmId(film.getId()) + "\n");
	}

	private void printAllFields(Film film) {
		StringBuilder sb = new StringBuilder("ID = " + film.getId());
		sb.append("\nTitle = " + film.getTitle());
		sb.append("\nDescription = " + film.getDescription());
		sb.append("\nRelease Year = " + film.getReleaseYear());
		sb.append("\nLanguage ID = " + film.getLanguageId());
		sb.append("\nLanguage = " + db.getLanguage(film));
		sb.append("\nRental Duration = " + film.getRentalDuration());
		sb.append("\nRental Rate = " + film.getRentalRate());
		sb.append("\nLength = " + film.getLength());
		sb.append("\nReplacement Cost = " + film.getReplacementCost());
		sb.append("\nRating = " + film.getRating());
		sb.append("\nSpecial Features = " + film.getSpecialfeatures());
		sb.append("\nCast = " + film.getCast());
		System.out.println(sb);
	}
}