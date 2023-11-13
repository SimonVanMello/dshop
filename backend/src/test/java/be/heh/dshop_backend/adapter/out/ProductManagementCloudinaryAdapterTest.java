package be.heh.dshop_backend.adapter.out;

import be.heh.dshop_backend.adapter.out.cloudinary.ProductManagementCloudinaryAdapter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagementCloudinaryAdapterTest {
    @Test
    public void invalidImageShouldReturnErrorMessage(){
        ProductManagementCloudinaryAdapter productManagementCloudinaryAdapter = new ProductManagementCloudinaryAdapter();
        String url = productManagementCloudinaryAdapter.saveImage("fakeImage".getBytes());
        assertEquals("Error uploading the image", url);
    }

    @Test
    public void validImageShouldBeUploadedOnCloudinary(){
        ProductManagementCloudinaryAdapter productManagementCloudinaryAdapter = new ProductManagementCloudinaryAdapter();
        // TODO: find a way to make this test
    }
}
