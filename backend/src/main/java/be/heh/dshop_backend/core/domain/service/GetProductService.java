package be.heh.dshop_backend.core.domain.service;

import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.in.GetProductUseCase;
import be.heh.dshop_backend.core.port.out.GetProductPersistenceOut;

public class GetProductService implements GetProductUseCase{
    private final GetProductPersistenceOut getProductPersistenceOut;

    public GetProductService(GetProductPersistenceOut getProductPersistenceOut){
        this.getProductPersistenceOut = getProductPersistenceOut;
    }

    @Override
    public Product getProduct(int id){
        return this.getProductPersistenceOut.getProduct(id);
    }
}
