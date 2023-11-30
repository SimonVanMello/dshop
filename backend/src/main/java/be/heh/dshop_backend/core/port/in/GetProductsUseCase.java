package be.heh.dshop_backend.core.port.in;

import be.heh.dshop_backend.core.domain.model.Product;
import java.util.ArrayList;

public interface GetProductsUseCase {
    ArrayList<Product> getProducts();
}
