package be.heh.dshop_backend.core.port.out;

import be.heh.dshop_backend.core.domain.model.Product;

import java.util.ArrayList;

public interface GetProductsPersistenceOut {
    ArrayList<Product> getProducts();
}
