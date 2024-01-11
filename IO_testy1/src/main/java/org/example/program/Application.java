package org.example.program;



import org.example.program.data.Data;
import org.example.program.movie.CollectorFilm;
import org.example.program.movie.Film;
import org.example.program.movie.RegularFilm;
import org.example.program.movie.RentedFilm;
import org.example.program.users.Account;
import org.example.program.users.Client;
import org.example.program.users.Employee;

import java.time.LocalDate;
import java.util.Scanner;
public class Application {
	/**
	 *
	 * @param title
	 * @param releaseYear
	 * @param genre
	 */
	public Film searchMovie(String title, int releaseYear, String genre) {
		return Data.INSTANCE.films.stream()
				.filter(w -> w.getTitle() == title && w.getReleaseYear() ==
						releaseYear && w.getGenre() == genre)
				.findFirst()
				.orElse(null);
	}
	/**
	 *
	 * @param title
	 * @param releaseYear
	 * @param genre
	 */
	public RentedFilm searchRented(String title, int releaseYear, String
			genre) {
		return Data.INSTANCE.rentedFilms.stream()
				.filter(w -> w.getFilm().getTitle() == title &&
						w.getFilm().getReleaseYear() == releaseYear && w.getFilm().getGenre() ==
						genre)
				.findFirst()
				.orElse(null);
	}
	public void userRegistration () {
		throw new UnsupportedOperationException();
	}
	/**
	 *
	 * @param firstName
	 * @param password
	 */
	public void login(String firstName, String password) {
// TODO - implement Application.login
		throw new UnsupportedOperationException();
	}
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Application application = new Application();
		application.menuForEmployee();
	}
	/**
	 *
	 * @param account
	 */
	public void changeAccountData(Account account) {
// TODO - implement Application.changeAccountData
		throw new UnsupportedOperationException();
	}
	/**
	 *
	 * @param
	 */
	public void addMovie() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("podaj tytuł filmu");
		String title = scanner.nextLine();
		System.out.println("podaj rok wydania");
		int releaseYear = scanner.nextInt();
		System.out.println("podaj gatunek filmu");
		String genre = scanner.next();
		System.out.println("""
czy jest to film kolekcjonerski?
jeśli tak wcisnij 1,
jeśli nie wciśnij 2
""");
		int answear = scanner.nextInt();
		Film film;
		if (answear == 1){
			film = new CollectorFilm(title,releaseYear,true,genre);
		}
		else{
			film = new RegularFilm(title,releaseYear,true,genre);
		}
		Employee.addFilm(film);
	}
	/**
	 *
	 * @param
	 */
	public void deleteMovie() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("podaj tytuł filmu");
		String title = scanner.nextLine();
		System.out.println("podaj rok wydania");
		int releaseYear = scanner.nextInt();
		System.out.println("podaj gatunek filmu");
		String genre = scanner.nextLine();
		Film film = searchMovie(title,releaseYear,genre);
		Employee.removeFilm(film);
	}
	/**
	 *
	 * @param newDate
	 */
	public void changeTimeRental(LocalDate newDate) {
// TODO - implement Application.changeTimeRental
		throw new UnsupportedOperationException();
	}
	/**
	 *
	 * @param rental
	 */
	public void approveRental(RentedFilm rental) {
// TODO - implement Application.approveRental
		throw new UnsupportedOperationException();
	}
	/**
	 *
	 * @param film
	 */
	public void bookMovie(Film film) {
// TODO - implement Application.bookMovie
		throw new UnsupportedOperationException();
	}
	public void menuForEmployee() {
		System.out.println("""
kliknij:
1. aby dodadać nowy film do zbioru
2. aby usunąć film ze zbioru
""");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		System.out.println("podaj tytuł filmu");
		String title = scanner.nextLine();
		System.out.println("podaj rok wydania");
		int releaseYear = scanner.nextInt();
		System.out.println("podaj gatunek filmu");
		String genre = scanner.nextLine();
		searchRented(title,releaseYear,genre);
		if(choice == 1){
			addMovie();
		}
		if (choice == 2){
			deleteMovie();
		}
	}
	public void menuCustomerRentedFilmManagement() {
		System.out.println("""
kliknij:
1. aby zgłosić zgube
2. aby przedłużyć czas wypożyczenia
""");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		System.out.println("podaj tytuł filmu");
		String title = scanner.nextLine();
		System.out.println("podaj rok wydania");
		int releaseYear = scanner.nextInt();
		System.out.println("podaj gatunek filmu");
		String genre = scanner.nextLine();
		RentedFilm rentedFilm = searchRented(title,releaseYear,genre);
		if(rentedFilm == null){
			return;
		}
		if(choice == 1){
			Client.reportLost(rentedFilm);
		}
		if (choice == 2){
			System.out.println("ile dni chcesz wydłużyć? ");
			int days = scanner.nextInt();
			Client.requestExtendedRentPeriod(rentedFilm,days);
		}
	}
}