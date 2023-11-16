package be.heh.dshop_backend.adapter.out;

import be.heh.dshop_backend.adapter.out.cloudinary.ProductManagementCloudinaryAdapter;
import be.heh.dshop_backend.core.port.in.ProductManagementAddCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductManagementCloudinaryAdapterTest {
    @Test
    public void passingInvalidImageToSaveImageShouldThrowException(){
        RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> {
                ProductManagementCloudinaryAdapter productManagementCloudinaryAdapter = new ProductManagementCloudinaryAdapter();

                ProductManagementAddCommand command = mock(ProductManagementAddCommand.class);
                when(command.getName()).thenReturn("productName");
                when(command.getPrice()).thenReturn(10.5);
                when(command.getQuantity()).thenReturn(1);
                when(command.getImage()).thenReturn("fakeImage".getBytes());

                productManagementCloudinaryAdapter.saveImage(command);
            },
            "Expected method to throw an error but it didn't"
        );
        assertTrue(exception.getMessage().contains("Invalid image file"));
    }

    @Test
    public void validImageShouldBeUploadedOnCloudinary(){
        ProductManagementCloudinaryAdapter productManagementCloudinaryAdapter = new ProductManagementCloudinaryAdapter();
        // TODO: find a way to make this test
    }

    @Test
    public void deletingExistingImageShouldReturnOK(){
        ProductManagementCloudinaryAdapter productManagementCloudinaryAdapter = new ProductManagementCloudinaryAdapter();
        // TODO: find a way to make this test
    }

    @Test
    public void deletingNonExistingImageShouldReturnNotFound(){
        ProductManagementCloudinaryAdapter productManagementCloudinaryAdapter = new ProductManagementCloudinaryAdapter();
        // TODO: find a way to make this test
    }
}
