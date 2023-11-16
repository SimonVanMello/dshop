package be.heh.dshop_backend.core.port.out;

import be.heh.dshop_backend.core.domain.model.Product;

public interface ProductManagementPersistenceOut {
    void addProduct(Product product);
    void modifyProduct(Product product);
    String removeProduct(int id);
}
