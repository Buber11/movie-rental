package org.example.program.movie;

import java.util.Objects;

public abstract class Film {
	private String title;
	private int releaseYear;
	private boolean available;
	private int rate;
	private String genre;
	private boolean lost;
	public String getTitle() {
		return this.title;
	}
	public String getGenre() {
		return this.genre;
	}
	public int getReleaseYear() {
		return this.releaseYear;
	}
	public boolean isAvailable() {
		return this.available;
	}

	public int getRate() {
		return rate;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	/**
	 *
	 * @param days
	 */
	public abstract int calculateRentalFee(int days);
	/**
	 *
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 *
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 *
	 * @param available
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
	/**
	 *
	 * @param title
	 * @param releaseYear
	 * @param available
	 * @param genre
	 */
	public Film(String title, int releaseYear, boolean available, String
			genre) {
		this.title = title;
		this.releaseYear = releaseYear;
		this.available = available;
		this.genre = genre;
	}
	public boolean getLost() {
		return this.lost;
	}
	/**
	 *
	 * @param lost
	 */
	public void setLost(boolean lost) {
		this.lost = lost;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Film film = (Film) o;
		return releaseYear == film.releaseYear && available == film.available && rate == film.rate && lost == film.lost && Objects.equals(title, film.title) && Objects.equals(genre, film.genre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, releaseYear, available, rate, genre, lost);
	}
}