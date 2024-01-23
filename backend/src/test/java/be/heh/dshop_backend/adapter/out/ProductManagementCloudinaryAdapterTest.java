package be.heh.dshop_backend.adapter.out;

import be.heh.dshop_backend.adapter.out.cloudinary.ProductManagementCloudinaryAdapter;
import be.heh.dshop_backend.core.port.in.ProductManagementAddCommand;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

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
        // Start by downloading an image from the internet
        byte[] imageBytes = null;
        try{
            String imageUrl = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";
            InputStream in = new URL(imageUrl).openStream();
            Path outputPath = Files.createTempFile("downloaded", ".png");
            Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
            imageBytes = Files.readAllBytes(outputPath);
        } catch (Exception e){
            fail("Failed to download image");
        }

        // Then upload it
        ProductManagementAddCommand command = mock(ProductManagementAddCommand.class);
        when(command.getName()).thenReturn("validImageShouldBeUploadedOnCloudinaryTest");
        when(command.getPrice()).thenReturn(10.5);
        when(command.getQuantity()).thenReturn(1);
        when(command.getImage()).thenReturn(imageBytes);

        String result = productManagementCloudinaryAdapter.saveImage(command);
        assertTrue(result.contains("https://res.cloudinary.com"));
    }

    @Test
    public void deletingExistingImageShouldReturnOK(){
        ProductManagementCloudinaryAdapter productManagementCloudinaryAdapter = new ProductManagementCloudinaryAdapter();
        final String productName = "uniqueProductName";
        // Start by uploading an image
        try{
            String imageUrl = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";
            InputStream in = new URL(imageUrl).openStream();
            Path outputPath = Files.createTempFile("downloaded", ".png");
            Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
            byte[] imageBytes = Files.readAllBytes(outputPath);

            ProductManagementAddCommand command = mock(ProductManagementAddCommand.class);
            when(command.getName()).thenReturn(productName);
            when(command.getPrice()).thenReturn(10.5);
            when(command.getQuantity()).thenReturn(1);
            when(command.getImage()).thenReturn(imageBytes);
            productManagementCloudinaryAdapter.saveImage(command);
        } catch (Exception e){
            fail("Failed to upload image");
        }

        // Then delete it
        String result = productManagementCloudinaryAdapter.deleteImage(productName);
        assertEquals("ok", result);
    }
}
