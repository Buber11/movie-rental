package org.example.program.movie;
public class RegularFilm extends Film {
	/**
	 *
	 * @param title
	 * @param releaseYear
	 * @param available
	 * @param genre
	 */
	public RegularFilm(String title, int releaseYear, boolean available,
					   String genre) {
		super(title,releaseYear,available,genre);
	}
	/**
	 *
	 * @param days
	 */
	public int calculateRentalFee(int days) {
		return days * this.getRate();
	}

}