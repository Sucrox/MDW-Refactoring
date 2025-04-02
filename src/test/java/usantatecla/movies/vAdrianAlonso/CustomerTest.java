package usantatecla.movies.vAdrianAlonso;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

	private final String CUSTOMER_NAME = "CUSTOMER_NAME";
	private final String MOVIE_NAME = "MOVIE_NAME";
	@Test
	public void withoutRentalsTest() {
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).build();
		String statement = customer.statement();
		String result = new StatementBuilder().customerName(CUSTOMER_NAME)
				.totalAmount(0).frequentRenterPoints(0).build();
		assertEquals(result, statement);
	}

	@Test
	public void regularRentalAmountTest() {
		Movie movie = new MovieBuilder().title(MOVIE_NAME).regular().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
		assertEquals(2.0, rental.getCharge(), 0.01);
		rental = new RentalBuilder().movie(movie).daysRented(4).build();
		assertEquals(5.0, rental.getCharge(), 0.01);
	}
	@Test
	public void childrenRentalAmountTest() {
		Movie movie = new MovieBuilder().title(MOVIE_NAME).childrens().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
		assertEquals(1.5, rental.getCharge(), 0.01);
		rental = new RentalBuilder().movie(movie).daysRented(4).build();
		assertEquals(6.0, rental.getCharge(), 0.01);
	}
	@Test
	public void newReleaseRentalAmountTest() {
		Movie movie = new MovieBuilder().title(MOVIE_NAME).newRelease().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
		assertEquals(3.0, rental.getCharge(), 0.01);
	}


	@Test
	public void regularFrequentPointTest() {
		Movie movie = new MovieBuilder().title(MOVIE_NAME).regular().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		assertEquals(1.0, rental.getFrequentRenterPoints(), 0.01);
	}
	@Test
	public void childrenFrequentPointTest() {
		Movie movie = new MovieBuilder().title(MOVIE_NAME).childrens().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		assertEquals(1.0, rental.getFrequentRenterPoints(), 0.01);
	}

	@Test
	public void newReleaseFrequentPointTest() {
		Movie movie = new MovieBuilder().title(MOVIE_NAME).newRelease().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		assertEquals(2.0, rental.getFrequentRenterPoints(), 0.01);
	}


	@Test
	public void regularResultTest() {
		Movie movie = new MovieBuilder().title(MOVIE_NAME).regular().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();

		String result = new StatementBuilder().customerName(CUSTOMER_NAME).movie(MOVIE_NAME, 3.5)
				.totalAmount(3.5).frequentRenterPoints(1).build();

		assertEquals(customer.statement(),result);
	}

	@Test
	public void childrenResultPointTest() {
		Movie movie = new MovieBuilder().title(MOVIE_NAME).childrens().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();

		String result = new StatementBuilder().customerName(CUSTOMER_NAME).movie(MOVIE_NAME, 1.5)
				.totalAmount(1.5).frequentRenterPoints(1).build();

		assertEquals(customer.statement(),result);
	}

	@Test
	public void newReleaseResultPointTest() {
		Movie movie = new MovieBuilder().title(MOVIE_NAME).newRelease().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();

		String result = new StatementBuilder().customerName(CUSTOMER_NAME).movie(MOVIE_NAME, 3.0)
				.totalAmount(3.0).frequentRenterPoints(2).build();

		assertEquals(customer.statement(),result);
	}



	@Test
	public void rentalTest() {
		String regularMovieName = "regularMovieName";
		Movie regularMovie = new MovieBuilder().title(regularMovieName).regular().build();
		Rental regularRental = new RentalBuilder().movie(regularMovie).daysRented(10).build();
		
		String newReleaseMovieName = "newReleaseMovieName";
		Movie newReleaseMovie = new MovieBuilder().title(newReleaseMovieName).newRelease().build();
		Rental newReleaseRental = new RentalBuilder().movie(newReleaseMovie).daysRented(10).build();
		
		String childrensMovieName = "childrensMovieName";
		Movie childrensMovie = new MovieBuilder().title(childrensMovieName).childrens().build();
		Rental childrensRental = new RentalBuilder().movie(childrensMovie).daysRented(10).build();
		
		String customerName = "CUSTOMER_NAME";
		Customer customer = new CustomerBuilder().name(customerName)
				.rental(regularRental).rental(newReleaseRental).rental(childrensRental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName)
				.movie(regularMovieName, 14).movie(newReleaseMovieName, 3).movie(childrensMovieName, 15)
				.totalAmount(32).frequentRenterPoints(4).build();
		assertEquals(result, statement);
	}
	
	
}
