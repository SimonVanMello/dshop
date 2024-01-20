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
    private final GetProductUseCase getProductUseCase;

    public ProductManagementService(
            ProductManagementPersistenceOut productManagementPersistenceOut,
            ProductManagementCloudinaryOut productManagementCloudinaryOut,
            GetProductsUseCase getProductsUseCase,
            GetProductUseCase getProductUseCase
    ){
        this.productManagementPersistenceOut = productManagementPersistenceOut;
        this.productManagementCloudinaryOut = productManagementCloudinaryOut;
        this.getProductsUseCase = getProductsUseCase;
        this.getProductUseCase = getProductUseCase;
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
    public void modifyProduct(ProductManagementModifyCommand command) throws Exception {
        try {
            // Check if the product exist
            getProductUseCase.getProduct(command.getId());
        }
        catch (Exception e){
            throw new Exception("this product doesn't exist");
        }

        String imgUrl = this.productManagementCloudinaryOut.modifyImage(command);
        Product product = new Product(
                command.getId(),
                command.getName(),
                command.getPrice(),
                imgUrl,
                command.getQuantity(),
                command.getImage()
        );
        this.productManagementPersistenceOut.modifyProduct(product);
    }

    @Override
    public void removeProduct(ProductManagementRemoveCommand command){
        String productName = this.productManagementPersistenceOut.removeProduct(command.getId());
        this.productManagementCloudinaryOut.deleteImage(productName);
    }
}
