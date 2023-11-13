package be.heh.dshop_backend.core.port.in;

import be.heh.dshop_backend.core.domain.model.Product;

public interface ProductManagementUseCase {
    Product addProduct(ProductManagementAddCommand command);
    void modifyProduct(ProductManagementModifyCommand command);
    void removeProduct(ProductManagementRemoveCommand command);
}
