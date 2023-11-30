package be.heh.dshop_backend.core.port.in;

import be.heh.dshop_backend.core.domain.model.Product;

public interface GetProductUseCase {
    Product getProduct(int id);
}
