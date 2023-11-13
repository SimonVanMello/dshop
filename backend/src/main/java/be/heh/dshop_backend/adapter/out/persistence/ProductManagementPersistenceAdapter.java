package be.heh.dshop_backend.adapter.out.persistence;

import be.heh.dshop_backend.common.UseCase;
import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.out.ProductManagementPersistenceOut;

@UseCase
public class ProductManagementPersistenceAdapter implements ProductManagementPersistenceOut {
    private ProductManagementRepository productManagementRepository;
    public ProductManagementPersistenceAdapter(ProductManagementRepository productManagementRepository){
        this.productManagementRepository =  productManagementRepository;
    }
    @Override
    public void addProduct(Product product){
        productManagementRepository.storeProduct(product);
    }

    @Override
    public void modifyProduct(Product product){

    }

    @Override
    public void removeProduct(int id) {

    }
}