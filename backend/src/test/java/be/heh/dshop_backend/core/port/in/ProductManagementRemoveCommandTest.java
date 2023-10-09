package be.heh.dshop_backend.core.port.in;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagementRemoveCommandTest {
    @Test
    public void negativeIdShouldThrowConstraintViolationException(){
        ConstraintViolationException exception = assertThrows(
                ConstraintViolationException.class,
                () -> new ProductManagementRemoveCommand(-1),
                "Expected constructor to throw but it didn't"
        );
        assertTrue(exception.getMessage().contains("id: must be greater than or equal to 0"));
    }

    @Test
    public void validIdShouldNotThrowException(){
        assertDoesNotThrow(
                () -> new ProductManagementRemoveCommand(1)
        );
    }
}
