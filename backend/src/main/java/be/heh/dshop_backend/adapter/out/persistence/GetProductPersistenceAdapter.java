package be.heh.dshop_backend.adapter.out.persistence;

import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.out.GetProductPersistenceOut;

public class GetProductPersistenceAdapter implements GetProductPersistenceOut {
    private GetProductRepository getProductRepository;

    public GetProductPersistenceAdapter(GetProductRepository getProductRepository){
        this.getProductRepository = getProductRepository;
    }

    @Override
    public Product getProduct(int id){
        return this.getProductRepository.getProduct(id);
    }
}
