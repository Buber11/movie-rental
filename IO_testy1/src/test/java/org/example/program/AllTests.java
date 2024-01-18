package org.example.program;

import org.example.program.data.Data;
import org.example.program.movie.CollectorFilm;
import org.example.program.movie.Film;
import org.example.program.movie.RegularFilm;
import org.example.program.movie.RentedFilm;
import org.example.program.users.Client;
import org.example.program.users.Employee;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

public class AllTests {
    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class SearchApplicationTest {

        private static Application application;
        private static Employee employeeMock;
        private static Client clientMock;

        @BeforeAll
        public static void setUp() {
            application = new Application();
            employeeMock = Mockito.mock(Employee.class);
            clientMock = Mockito.mock(Client.class);
            Data.INSTANCE.films = createSampleFilms();
            Data.INSTANCE.rentedFilms = createSampleRentedFilms();
        }

        @org.junit.jupiter.api.Test
        @Order(1)
        public void testSearchMovie() {
            Film result = application.searchMovie("Movie1", 2022, "Action");

            assertNotNull(result);
            assertEquals("film nie został znaleziony","Movie1", result.getTitle());

            result = application.searchMovie("Movie2", 2021,"Drama");
            assertNotNull(result);
            assertEquals("film nie został znaleziony","Movie2", result.getTitle());

        }

        @Test
        @Order(2)
        public void testSearchRented() {
            RentedFilm result = application.searchRented("Movie2", 2021, "Drama");
            assertNotNull(result);
            assertEquals("wypożyczenie nie zostało znalezione","Movie2", result.getFilm().getTitle());
        }

        private static List<Film> createSampleFilms() {
            List<Film> films = new ArrayList<>();
            films.add(new CollectorFilm("Movie1", 2022, true, "Action"));
            films.add(new RegularFilm("Movie2", 2021, true, "Drama"));
            return films;
        }

        // Helper method to create sample rented films for testing
        private static List<RentedFilm> createSampleRentedFilms() {
            List<RentedFilm> rentedFilms = new ArrayList<>();
            rentedFilms.add(new RentedFilm(new RegularFilm("Movie2", 2021, true, "Drama"),clientMock,employeeMock,10));
            return rentedFilms;
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class EmployeeTest {
        static Film film;
        @BeforeAll
        public static void setUp(){
            film = new RegularFilm("kot w butach",2002,true,"animacja");
        }

        @AfterEach
        public void afterSetUp(){
            Data.INSTANCE.films = new ArrayList<>();
        }
        @org.junit.jupiter.api.Test
        @Order(1)
        public void addMovie(){
            assertTrue("lista nie jest pusta przed operacją",Data.INSTANCE.getFilms().isEmpty());

            Employee.addFilm(film);

            assertTrue("lista jest pusta po operacji dodania",Data.INSTANCE.getFilms().contains(film));
        }
        @org.junit.jupiter.api.Test
        @Order(2)
        public void deleteMovie(){
            Employee.addFilm(film);
            assertTrue("lista nie zawiera filmu który mamy usunąć",Data.INSTANCE.films.contains(film));

            Employee.removeFilm(film);

            assertFalse("flim nie został usunięty z listy",Data.INSTANCE.getFilms().contains(film));
        }
        @Test
        @Order(5)
        public void testDeleteNonexistentMovie() {
            assertFalse("lista zwiera film którego nie powinna mieć",Data.INSTANCE.films.contains(film));

            Employee.removeFilm(film);

            assertFalse("lista zawiera film którego wcześniej na niej nie było",Data.INSTANCE.getFilms().contains(film));
        }
        @org.junit.jupiter.api.Test
        @Order(3)
        public void calculateRateTest(){
            RegularFilm mockFilm = Mockito.mock(RegularFilm.class);
            Mockito.when(mockFilm.calculateRentalFee(10)).thenReturn(50);
            int result = mockFilm.calculateRentalFee(10);
            verify(mockFilm).calculateRentalFee(10);

            Film film = new RegularFilm("x",200,true,"art");
            film.setRate(5);

            assertTrue("wyniki dwóch operacji są niezgodne",film.calculateRentalFee(10) ==  result);
        }

        @Test
        @Order(4)
        public void addMovieMockito(){
            Data mockData = Mockito.mock(Data.class);
            Mockito.when(mockData.getFilms()).thenReturn(new ArrayList<>(List.of(film)));

            Employee.addFilm(film);

            assertEquals("listy nie są sobie równe",Data.INSTANCE.films,mockData.getFilms());
        }
    }
    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class ApplicationTest{

        Application application;
        Film collectionFilm;
        Film regularFilm;
        Scanner scanner;
        @BeforeAll
        public void setUp(){
            application = new Application();
            collectionFilm = new CollectorFilm("Barbie",2022,true,"Hit");
            regularFilm = new RegularFilm("Barbie",2022,true,"Hit");
        }
        @AfterEach
        public void delteList(){
           Data.INSTANCE.films = new ArrayList<>();
        }
        @Test
        @Order(1)
        public void testAddCollectionMovieFromApplication() {
            String input = "Barbie\n2022\nHit\n1\n";
            scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
            assertTrue("lista nie jest pusta",Data.INSTANCE.films.isEmpty());

            application.addMovie(scanner);


            assertFalse("lista jest pusta",Data.INSTANCE.films.isEmpty());

            assertTrue("lista nie zawiera filmu",Data.INSTANCE.films.contains(collectionFilm));
            assertFalse("lista zawiera film złego typu",Data.INSTANCE.films.contains(regularFilm));

        }
        @Test
        @Order(2)
        public void testAddRegularMovieFromApplication() {
            String input = "Barbie\n2022\nHit\n0\n";
            scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
            assertTrue("lista nie jest pusta",Data.INSTANCE.films.isEmpty());

            application.addMovie(scanner);

            assertFalse("lista jest pusta po wykonaiu eperacji",Data.INSTANCE.films.isEmpty());

            assertFalse("lista zawiera film złego typu",Data.INSTANCE.films.contains(collectionFilm));
            assertTrue("lista nie zawiera naszego filmu",Data.INSTANCE.films.contains(regularFilm));

        }
        @Test
        void testAddMovieInvalidReleaseYear() {
            String input = "SomeTitle\nInvalidYear\nSomeGenre\n0\n";
            Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
            assertThrows(NumberFormatException.class, () -> application.addMovie(scanner));
        }

        @Test
        void testAddMovieInvalidChoice() {
            String input = "SomeTitle\n2022\nSomeGenre\nInvalidChoice\n";
            Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

            assertThrows(NumberFormatException.class, () -> application.addMovie(scanner));
        }

    }


}
