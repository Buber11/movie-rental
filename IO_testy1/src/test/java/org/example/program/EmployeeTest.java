package org.example.program;

import org.example.program.data.Data;
import org.example.program.movie.Film;
import org.example.program.movie.RegularFilm;
import org.example.program.movie.RentedFilm;
import org.example.program.users.Employee;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import static org.junit.Assert.*;

public class EmployeeTest {
    Film film;
    @Before
    public void setUp(){
        film = new RegularFilm("kot w butach",2002,true,"animacja");
    }
    @Test
    public void addMovie(){
        assertTrue(Data.INSTANCE.getFilms().isEmpty());

        Employee.addFilm(film);

        assertTrue(Data.INSTANCE.getFilms().contains(film));
    }
    @Test
    public void deleteMovie(){

        Employee.addFilm(film);

        assertTrue(Data.INSTANCE.getFilms().contains(film));

        Employee.removeFilm(film);

        assertFalse(Data.INSTANCE.getFilms().contains(film));
    }
}
