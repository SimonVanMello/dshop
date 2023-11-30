package be.heh.dshop_backend.core.domain.service;

import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.in.GetProductsUseCase;
import be.heh.dshop_backend.core.port.out.GetProductsPersistenceOut;

import java.util.ArrayList;

public class GetProductsService implements GetProductsUseCase {
    private final GetProductsPersistenceOut getProductsPersistenceOut;

    public GetProductsService(GetProductsPersistenceOut getProductsPersistenceOut){
        this.getProductsPersistenceOut = getProductsPersistenceOut;
    }

    @Override
    public ArrayList<Product> getProducts(){
        return this.getProductsPersistenceOut.getProducts();
    }
}
