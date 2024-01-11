package org.example.program.movie;

import org.example.program.users.Client;
import org.example.program.users.Employee;

import java.time.LocalDate;
public class RentedFilm {
	private Film film;
	private Client client;
	private Employee employee;
	private int cost;
	private LocalDate returnByDate;
	/**
	 *
	 * @param film
	 * @param customer
	 * @param employee
	 * @param cost
	 */
	public RentedFilm(Film film, Client customer, Employee employee, int
			cost) {
		this.film = film;
		this.client = customer;
		this.employee = employee;
		this.cost = cost;
	}
	public Film getFilm() {
		return this.film;
	}
	/**
	 *
	 * @param film
	 */
	public void setFilm(Film film) {
		this.film = film;
	}
	public Client getCustomer() {
// TODO - implement RentedFilm.getCustomer
		throw new UnsupportedOperationException();
	}
	/**
	 *
	 * @param customer
	 */
	public void setCustomer(Client customer) {
		this.client = customer;
	}
	public Employee getEmployee() {
		return this.employee;
	}
	/**
	 *
	 * @param employee
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getCost() {
		return this.cost;
	}
	/**
	 *
	 * @param cost
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
	public LocalDate getReturnByDate() {
		return this.returnByDate;
	}
	/**
	 *
	 * @param returnByDate
	 */
	public void setReturnByDate(LocalDate returnByDate) {
		this.returnByDate = returnByDate;
	}
}