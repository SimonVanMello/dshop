package be.heh.dshop_backend.core.domain.service;

import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.in.ProductManagementAddCommand;
import be.heh.dshop_backend.core.port.in.ProductManagementModifyCommand;
import be.heh.dshop_backend.core.port.in.ProductManagementRemoveCommand;
import be.heh.dshop_backend.core.port.in.ProductManagementUseCase;
import be.heh.dshop_backend.core.port.out.ProductManagementCloudinaryOut;
import be.heh.dshop_backend.core.port.out.ProductManagementPersistenceOut;

public class ProductManagementService implements ProductManagementUseCase {
    private final ProductManagementPersistenceOut productManagementPersistenceOut;
    private final ProductManagementCloudinaryOut productManagementCloudinaryOut;

    public ProductManagementService(
            ProductManagementPersistenceOut productManagementPersistenceOut,
            ProductManagementCloudinaryOut productManagementCloudinaryOut
    ){
        this.productManagementPersistenceOut = productManagementPersistenceOut;
        this.productManagementCloudinaryOut = productManagementCloudinaryOut;
    }

    @Override
    public Product addProduct(ProductManagementAddCommand command){
        String imgUrl = this.productManagementCloudinaryOut.saveImage(command);
        Product product = new Product(
            command.getName(),
            command.getPrice(),
            imgUrl,
            command.getQuantity(),
            command.getImage()
        );
        this.productManagementPersistenceOut.addProduct(product);

        return product;
    }

    @Override
    public void modifyProduct(ProductManagementModifyCommand command){

    }

    @Override
    public void removeProduct(ProductManagementRemoveCommand command){
        String productName = this.productManagementPersistenceOut.removeProduct(command.getId());
        System.out.println(productName);
        this.productManagementCloudinaryOut.deleteImage(productName);
    }
}
