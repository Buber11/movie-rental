package org.example.program.users;


import org.example.program.movie.RentedFilm;

public class Client {
	private Account account;
	/**
	 *
	 * @param rentedFilm
	 */
	public static void filmReservation(RentedFilm rentedFilm) {
// TODO - implement Client.filmReservation
		throw new UnsupportedOperationException();
	}
	/**
	 *
	 * @param rentedFilm
	 */
	public static void reportLost(RentedFilm rentedFilm) {
		rentedFilm.getFilm().setLost(true);
	}
	/**
	 *
	 * @param rentedFilm
	 */
	public static void requestExtendedRentPeriod(RentedFilm rentedFilm,int
			days) {
		rentedFilm.getReturnByDate().plusDays(days);
	}
	/**
	 *
	 * @param account
	 */
	public Client(Account account) {
// TODO - implement Client.Client
		throw new UnsupportedOperationException();
	}
}