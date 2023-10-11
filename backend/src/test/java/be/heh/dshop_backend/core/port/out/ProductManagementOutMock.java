package be.heh.dshop_backend.core.port.out;

import be.heh.dshop_backend.core.domain.model.Product;

import java.util.ArrayList;

public class ProductManagementOutMock implements ProductManagementOut {

    private final ArrayList<Product> database = new ArrayList<>();

    @Override
    public void addProduct(Product product){
        this.database.add(product);
    }

    @Override
    public void modifyProduct(Product product){

    }

    @Override
    public void removeProduct(int id){

    }
}
