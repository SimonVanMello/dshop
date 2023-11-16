package be.heh.dshop_backend.adapter.out;

import be.heh.dshop_backend.adapter.out.cloudinary.ProductManagementCloudinaryAdapter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagementCloudinaryAdapterTest {
    @Test
    public void invalidImageShouldReturnErrorMessage(){
        ProductManagementCloudinaryAdapter productManagementCloudinaryAdapter = new ProductManagementCloudinaryAdapter();
        // TODO: create ProductManagementCommand to pass it to saveImage
        //String url = productManagementCloudinaryAdapter.saveImage();
        //assertEquals("Error uploading the image", url);
    }

    @Test
    public void validImageShouldBeUploadedOnCloudinary(){
        ProductManagementCloudinaryAdapter productManagementCloudinaryAdapter = new ProductManagementCloudinaryAdapter();
        // TODO: find a way to make this test
    }
}
