package be.heh.dshop_backend.core.port.in;

import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.out.ProductManagementOut;

public interface ProductManagementUseCase {
    public Product addProduct(ProductManagementAddCommand command);
    public void modifyProduct(ProductManagementModifyCommand command);
    public void removeProduct(ProductManagementRemoveCommand command);
}
