package be.heh.dshop_backend.core.port.in;

import be.heh.dshop_backend.core.domain.model.Product;

public interface ProductManagementUseCase {
    Product addProduct(ProductManagementAddCommand command);
    Product modifyProduct(ProductManagementModifyCommand command) throws Exception;
    void removeProduct(ProductManagementRemoveCommand command);
}
