package org.example.program.movie;
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
}