package com.skilldistillery.filmquery.entities;

import java.sql.Date;
import java.util.List;

public class Film {
	private int id;
	private String title;
	private String description;
	private Date releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialfeatures;
	private List<Actor> cast;

	public List<Actor> getCast() {
		return cast;
	}



	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}



	public Film(int id, String title, String description, Date releaseYear, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialfeatures, List<Actor> cast) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialfeatures = specialfeatures;
		this.cast = cast;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialfeatures() {
		return specialfeatures;
	}

	public void setSpecialfeatures(String specialfeatures) {
		this.specialfeatures = specialfeatures;
	}
@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ID = ");
		builder.append(id);
		builder.append("\n Title = ");
		builder.append(title);
		builder.append("\n Description = ");
		builder.append(description);
		builder.append("\n Release Year = ");
		builder.append(releaseYear);
		builder.append("\n Language ID = ");
		builder.append(languageId);
		builder.append("\n Rental Duration = ");
		builder.append(rentalDuration);
		builder.append("\n Rental Rate = ");
		builder.append(rentalRate);
		builder.append("\n Length = ");
		builder.append(length);
		builder.append("\n Replacement Cost = ");
		builder.append(replacementCost);
		builder.append("\n Rating = ");
		builder.append(rating);
		builder.append("\n Special Features = ");
		builder.append(specialfeatures);
		
		return builder.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
