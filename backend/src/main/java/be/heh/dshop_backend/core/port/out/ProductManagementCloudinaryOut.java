package be.heh.dshop_backend.core.port.out;

import be.heh.dshop_backend.core.port.in.ProductManagementAddCommand;
import be.heh.dshop_backend.core.port.in.ProductManagementModifyCommand;

public interface ProductManagementCloudinaryOut {
    String saveImage(ProductManagementAddCommand command);

    String modifyImage(ProductManagementModifyCommand command);
    String deleteImage(String productName);
}