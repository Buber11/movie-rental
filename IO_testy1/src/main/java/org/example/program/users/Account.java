package org.example.program.users;
public class Account {
	private String firstName;
	private String lastName;
	private String password;
	public void getFirstName() {
// TODO - implement Account.getFirstName
		throw new UnsupportedOperationException();
	}
	/**
	 *
	 * @param imie
	 */
	public void setFirstName(String imie) {
		this.firstName = imie;
	}
	public void getLastName() {
// TODO - implement Account.getLastName
		throw new UnsupportedOperationException();
	}
	/**
	 *
	 * @param nazwisko
	 */
	public void setLastName(String nazwisko) {
		this.lastName = nazwisko;
	}
	public void getPassword() {
// TODO - implement Account.getPassword
		throw new UnsupportedOperationException();
	}
	/**
	 *
	 * @param haslo
	 */
	public void setPassword(String haslo) {
		this.password = haslo;
	}
	/**
	 *
	 * @param firstName
	 * @param lastName
	 * @param password
	 */
	public Account(String firstName, String lastName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
}