package be.heh.dshop_backend.adapter.out.cloudinary;

import be.heh.dshop_backend.common.UseCase;
import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.out.ProductManagementCloudinaryOut;

@UseCase
public class ProductManagementCloudinaryAdapter implements ProductManagementCloudinaryOut {
    @Override
    public String saveImage(byte[] image){
        return "";
    }
}
