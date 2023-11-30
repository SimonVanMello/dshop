package be.heh.dshop_backend.core.port.out;

import be.heh.dshop_backend.core.domain.model.Product;

public interface GetProductPersistenceOut {
    Product getProduct(int id);
}
