package org.example.program;

import org.example.program.data.Data;
import org.example.program.movie.Film;
import org.example.program.movie.RegularFilm;
import org.example.program.movie.RentedFilm;
import org.example.program.users.Client;
import org.example.program.users.Employee;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApplicationTest {


    private Application application;
    private Data dataMock;
    private Employee mockEmployee;
    private Film mockFilm;
    private Client mockCustomer;

    @Before
    public void setUp() {
        application = new Application();
        dataMock = mock(Data.class);
        mockEmployee = mock(Employee.class);
        mockFilm = mock(Film.class);
        mockCustomer = mock(Client.class);

        Data.INSTANCE.rentedFilms.add(new RentedFilm(new RegularFilm("MockFilm", 2022,true, "MockGenre"),mockCustomer,mockEmployee,10));
    }

    @org.junit.Test
    public void createRentedFilm() {
        RentedFilm rentedFilm = new RentedFilm(mockFilm, mockCustomer, mockEmployee, 10);
        assertNotNull(rentedFilm);
        assertEquals(mockFilm, rentedFilm.getFilm());
        assertEquals(mockCustomer, rentedFilm.getCustomer());
        assertEquals(mockEmployee, rentedFilm.getEmployee());
        assertEquals(10, rentedFilm.getCost());
    }

    @Test
    public void searchRented() {
        Application application = new Application();
        Data dataMock = mock(Data.class);
        Employee mockEmployee = mock(Employee.class);
        Film mockFilm = mock(Film.class);
        Client mockClient = mock(Client.class);

        List<RentedFilm> mockRentedFilms = Collections.singletonList(new RentedFilm(mockFilm, mockClient, mockEmployee, 0));

        // Use when() on a method call to the mock object
        when(dataMock.getRentedFilms()).thenReturn(mockRentedFilms);

        RentedFilm foundRentedFilm = application.searchRented("MockFilm", 2022, "MockGenre");
        assertNotNull(foundRentedFilm);
        assertEquals("MockFilm", foundRentedFilm.getFilm().getTitle());
    }
}



//    @Test
//    public void userRegistration() {
//        Application application = new Application();
//        assertThrows(UnsupportedOperationException.class, application::userRegistration);
//    }
//
////    @Test
////    public void addMovie() {
////        Application application = new Application();
////        application.addMovie();
////
////        List<Film> mockFilms = new ArrayList<>();
////        when(dataMock.getFilms()).thenReturn(mockFilms);
////
////        // Check if the film is added correctly to the Employee's film list
////        assertEquals(1, mockFilms.size());
////
////        when(dataMock.getFilms()).thenReturn(new ArrayList<>()); // Reset mock
////    }
////
////    @Test
////    public void deleteMovie() {
////        Application application = new Application();
////        application.deleteMovie();
////
////        List<Film> mockFilms = Collections.singletonList(new RegularFilm("MockFilm", 2022, true, "MockGenre"));
////        when(dataMock.getFilms()).thenReturn(mockFilms);
////
////        // Check if the film is removed correctly from the Employee's film list
////        assertEquals(0, mockFilms.size());
////
////        when(dataMock.getFilms()).thenReturn(new ArrayList<>()); // Reset mock
////    }
//
//    @Test
//    public void changeTimeRental() {
//        Application application = new Application();
//        assertThrows(UnsupportedOperationException.class, () -> application.changeTimeRental(LocalDate.now()));
//    }
//
//    @Test
//    public void approveRental() {
//        Application application = new Application();
//        RentedFilm mockRentedFilm = mock(RentedFilm.class);
//        assertThrows(UnsupportedOperationException.class, () -> application.approveRental(mockRentedFilm));
//    }
//
//    @Test
//    public void bookMovie() {
//        Application application = new Application();
//        Film mockFilm = mock(Film.class);
//        assertThrows(UnsupportedOperationException.class, () -> application.bookMovie(mockFilm));
//    }
//
//    @Test
//    public void menuForEmployee() {
//        Application application = new Application();
//        // You may use Mockito to mock Scanner input, but it can get complex
//        // It's suggested to manually test this method
//    }
//
//    @Test
//    public void menuCustomerRentedFilmManagement() {
//        Application application = new Application();
//        // Similar to menuForEmployee, it's challenging to test Scanner input
//        // Manually test this method and check interactions with the Client class
//    }
//
//    // Helper method to set a mock Data instance in Application
//    private void setDataMock(Application application, Data dataMock) {
//        try {
//            java.lang.reflect.Field field = Application.class.getDeclaredField("data");
//            field.setAccessible(true);
//            field.set(application, dataMock);
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//}
