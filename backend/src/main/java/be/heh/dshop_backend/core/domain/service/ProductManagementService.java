package be.heh.dshop_backend.core.domain.service;

import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.in.ProductManagementAddCommand;
import be.heh.dshop_backend.core.port.in.ProductManagementModifyCommand;
import be.heh.dshop_backend.core.port.in.ProductManagementRemoveCommand;
import be.heh.dshop_backend.core.port.in.ProductManagementUseCase;
import be.heh.dshop_backend.core.port.out.ProductManagementOut;

public class ProductManagementService implements ProductManagementUseCase {
    private final ProductManagementOut out;

    public ProductManagementService(ProductManagementOut out){
        this.out = out;
    }

    @Override
    public Product addProduct(ProductManagementAddCommand command){
        Product product = new Product(
            command.getName(),
            command.getPrice(),
            command.getImage(),
            command.getQuantity()
        );
        this.out.addProduct(product);
        return product;
    }

    @Override
    public void modifyProduct(ProductManagementModifyCommand command){

    }

    @Override
    public void removeProduct(ProductManagementRemoveCommand command){
        this.out.removeProduct(command.getId());
    }
}
