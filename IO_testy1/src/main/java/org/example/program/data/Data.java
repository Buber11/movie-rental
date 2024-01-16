package org.example.program.data;



import org.example.program.movie.Film;
import org.example.program.movie.RentedFilm;

import java.util.ArrayList;
import java.util.List;


public class Data {
	public List<RentedFilm> rentedFilms = new ArrayList<RentedFilm>();
	public List<Film> films = new ArrayList<Film>();
	public static Data INSTANCE = new Data();
	private Data() {
	}

	public List<RentedFilm> getRentedFilms() {
		return rentedFilms;
	}

	public List<Film> getFilms() {
		return films;
	}

	public static Data getINSTANCE() {
		return INSTANCE;
	}
}