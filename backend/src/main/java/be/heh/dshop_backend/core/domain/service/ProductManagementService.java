package be.heh.dshop_backend.core.domain.service;

import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.in.*;
import be.heh.dshop_backend.core.port.out.ProductManagementCloudinaryOut;
import be.heh.dshop_backend.core.port.out.ProductManagementPersistenceOut;

import java.util.ArrayList;
import java.util.Objects;

public class ProductManagementService implements ProductManagementUseCase {
    private final ProductManagementPersistenceOut productManagementPersistenceOut;
    private final ProductManagementCloudinaryOut productManagementCloudinaryOut;
    private final GetProductsUseCase getProductsUseCase;

    public ProductManagementService(
            ProductManagementPersistenceOut productManagementPersistenceOut,
            ProductManagementCloudinaryOut productManagementCloudinaryOut,
            GetProductsUseCase getProductsUseCase
    ){
        this.productManagementPersistenceOut = productManagementPersistenceOut;
        this.productManagementCloudinaryOut = productManagementCloudinaryOut;
        this.getProductsUseCase = getProductsUseCase;
    }

    @Override
    public Product addProduct(ProductManagementAddCommand command){
        ArrayList<Product> products = getProductsUseCase.getProducts();
        products.forEach(product -> {
            if (Objects.equals(product.getName(), command.getName())){
                throw new RuntimeException("This name is already used");
            }
        });

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
        this.productManagementCloudinaryOut.deleteImage(productName);
    }
}
