package be.heh.dshop_backend.adapter.out;

import be.heh.dshop_backend.adapter.out.cloudinary.ProductManagementCloudinaryAdapter;
import org.junit.jupiter.api.Test;

public class ProductManagementCloudinaryAdapterTest {
    @Test
    public void saveImageShouldSaveTheImage(){
        ProductManagementCloudinaryAdapter productManagementCloudinaryAdapter = new ProductManagementCloudinaryAdapter();
        productManagementCloudinaryAdapter.saveImage("test".getBytes());
    }
}
