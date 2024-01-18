package org.example.program;

import org.example.program.data.Data;
import org.example.program.movie.CollectorFilm;
import org.example.program.movie.Film;
import org.example.program.movie.RegularFilm;
import org.example.program.movie.RentedFilm;
import org.example.program.users.Client;
import org.example.program.users.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class ApplicationTest {

    private Application application;
    private Employee employeeMock;
    private Client clientMock;

    @Before
    public void setUp() {
        application = new Application();
        employeeMock = Mockito.mock(Employee.class);
        clientMock = Mockito.mock(Client.class);
        Data.INSTANCE.films = createSampleFilms();
        Data.INSTANCE.rentedFilms = createSampleRentedFilms();
    }

    @org.junit.Test
    public void testSearchMovie() {
        Film result = application.searchMovie("Movie1", 2022, "Action");

        assertNotNull(result);
        assertEquals("Movie1", result.getTitle());
    }

    @Test
    public void testSearchRented() {
        RentedFilm result = application.searchRented("Movie2", 2021, "Drama");
        assertNotNull(result);
        assertEquals("Movie2", result.getFilm().getTitle());
    }

    // Helper method to create sample films for testing
    private List<Film> createSampleFilms() {
        List<Film> films = new ArrayList<>();
        films.add(new CollectorFilm("Movie1", 2022, true, "Action"));
        films.add(new RegularFilm("Movie2", 2021, true, "Drama"));
        return films;
    }

    // Helper method to create sample rented films for testing
    private List<RentedFilm> createSampleRentedFilms() {
        List<RentedFilm> rentedFilms = new ArrayList<>();
        rentedFilms.add(new RentedFilm(new RegularFilm("Movie2", 2021, true, "Drama"),clientMock,employeeMock,10));
        return rentedFilms;
    }
}

