package org.example.program;

import org.example.program.movie.RegularFilm;
import org.example.program.users.Employee;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {

    RegularFilm regularFilm;

   @BeforeEach
   public void setUp(){
       regularFilm = new RegularFilm("lot nad gniazdem",2000,true,"klasyka");

   }
   @Test
    public void addMovieTest(){
       Employee.addFilm(regularFilm);
   }
  
}