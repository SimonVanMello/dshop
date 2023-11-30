package be.heh.dshop_backend.adapter.out.persistence;

import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.out.GetProductsPersistenceOut;

import java.util.ArrayList;

public class GetProductsPersistenceAdapter implements GetProductsPersistenceOut {
    private GetProductsRepository getProductsRepository;

    public GetProductsPersistenceAdapter(GetProductsRepository getProductsRepository){
        this.getProductsRepository = getProductsRepository;
    }

    @Override
    public ArrayList<Product> getProducts(){
        return this.getProductsRepository.getProducts();
    }
}
