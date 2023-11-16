package be.heh.dshop_backend.core.port.out;

import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.in.ProductManagementAddCommand;

public interface ProductManagementCloudinaryOut {
    String saveImage(ProductManagementAddCommand command);
}