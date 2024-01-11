package org.example.program.users;


import org.example.program.data.Data;
import org.example.program.movie.Film;
import org.example.program.movie.RentedFilm;

public class Employee {
	private Account account;
	/**
	 *
	 * @param rentedFilm
	 */
	public static void confirmRent(RentedFilm rentedFilm) {
// TODO - implement Employee.confirmRent
		throw new UnsupportedOperationException();
	}
	/**
	 *
	 * @param rendtedFilm
	 * @param daysToExtend
	 */
	public static void extendRentPeriod(RentedFilm rendtedFilm, long
			daysToExtend) {
// TODO - implement Employee.extendRentPeriod
		throw new UnsupportedOperationException();
	}
	/**
	 *
	 * @param film
	 */
	public static void addFilm(Film film) {
		Data.INSTANCE.films.add(film);
		Data.INSTANCE.films.stream().forEach(System.out::println);
	}
	/**
	 *
	 * @param film
	 */
	public static void removeFilm(Film film) {
		Data.INSTANCE.films.remove(film);
		Data.INSTANCE.films.stream().forEach(e ->e.toString());
	}
	/**
	 *
	 * @param account
	 */
	public Employee(Account account) {
// TODO - implement Employee.Employee
		throw new UnsupportedOperationException();
	}
}