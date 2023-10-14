package be.heh.dshop_backend.core.port.out;

import be.heh.dshop_backend.core.domain.model.Product;

public interface ProductManagementOut {
    public void addProduct(Product product);
    public void modifyProduct(Product product);
    public void removeProduct(int id);
}
