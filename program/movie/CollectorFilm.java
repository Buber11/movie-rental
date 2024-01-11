package org.example.program.movie;
public class CollectorFilm extends Film {
	/**
	 *
	 * @param title
	 * @param releaseYear
	 * @param available
	 * @param genre
	 */
	public CollectorFilm(String title, int releaseYear, boolean available,
						 String genre) {
		super(title,releaseYear,available,genre);
	}
	/**
	 *
	 * @param days
	 */
	public int calculateRentalFee(int days) {
// TODO - implement CollectorFilm.calculateRentalFee
		throw new UnsupportedOperationException();
	}
}