package be.heh.dshop_backend.core.port.out;

import be.heh.dshop_backend.core.domain.model.Product;

public interface Database {
    public void saveProduct(Product product);
    public void modifyProduct(Product product);
    public void removeProduct(Product product);
}
