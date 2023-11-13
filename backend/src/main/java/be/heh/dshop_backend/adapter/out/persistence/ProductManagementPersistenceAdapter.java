package be.heh.dshop_backend.adapter.out.persistence;

import be.heh.dshop_backend.common.UseCase;
import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.out.ProductManagementPersistenceOut;

@UseCase
public class ProductManagementPersistenceAdapter implements ProductManagementPersistenceOut {
    @Override
    public void addProduct(Product product){
        System.out.println(product.getImgUrl());
    }

    @Override
    public void modifyProduct(Product product){

    }

    @Override
    public void removeProduct(int id) {

    }
}
