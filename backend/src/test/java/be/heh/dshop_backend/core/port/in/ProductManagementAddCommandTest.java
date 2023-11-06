package be.heh.dshop_backend.core.port.in;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagementAddCommandTest {
	@Test
	public void emptyNameShouldThrowConstraintViolationException(){
		ConstraintViolationException exception = assertThrows(
			ConstraintViolationException.class,
			() -> new ProductManagementAddCommand(
				"",
				10.5,
				1,
				"fakeImage".getBytes()
			),
			"Expected constructor to throw but it didn't"
		);
		assertTrue(exception.getMessage().contains("name: must not be empty"));
	}

	@Test
	public void invalidPriceShouldThrowConstraintViolationException(){
		ConstraintViolationException exception = assertThrows(
			ConstraintViolationException.class,
			() -> new ProductManagementAddCommand(
				"productName",
				-10.5,
				1,
				"fakeImage".getBytes()
			),
			"Expected constructor to throw but it didn't"
		);
		assertTrue(exception.getMessage().contains("price: must be greater than or equal to 0"));
	}

	@Test
	public void invalidQuantityShouldThrowConstraintViolationException(){
		ConstraintViolationException exception = assertThrows(
			ConstraintViolationException.class,
			() -> new ProductManagementAddCommand(
				"productName",
				10.5,
				-1,
				"fakeImage".getBytes()
			),
			"Expected constructor to throw but it didn't"
		);
		assertTrue(exception.getMessage().contains("quantity: must be greater than or equal to 1"));
	}

	@Test
	public void emptyImageShouldThrowConstraintViolationException(){
		ConstraintViolationException exception = assertThrows(
			ConstraintViolationException.class,
			() -> new ProductManagementAddCommand(
				"productName",
				10.5,
				1,
				"".getBytes()
			),
			"Expected constructor to throw but it didn't"
		);
		assertTrue(exception.getMessage().contains("image: must not be empty"));
	}

	@Test
	public void validValuesShouldNotThrowException(){
		assertDoesNotThrow(
			() -> new ProductManagementAddCommand(
				"productName",
				10.5,
				1,
				"fakeImage".getBytes()
			)
		);
	}
}
