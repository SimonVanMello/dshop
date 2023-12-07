package be.heh.dshop_backend.core.domain.service;

import be.heh.dshop_backend.adapter.out.persistence.GetProductPersistenceAdapter;
import be.heh.dshop_backend.adapter.out.persistence.GetProductRepository;
import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.in.*;
import be.heh.dshop_backend.core.port.out.ProductManagementCloudinaryOut;
import be.heh.dshop_backend.core.port.out.ProductManagementPersistenceOut;

public class ProductManagementService implements ProductManagementUseCase {
    private final ProductManagementPersistenceOut productManagementPersistenceOut;
    private final ProductManagementCloudinaryOut productManagementCloudinaryOut;
    private final GetProductUseCase getProductUseCase;

    public ProductManagementService(
            ProductManagementPersistenceOut productManagementPersistenceOut,
            ProductManagementCloudinaryOut productManagementCloudinaryOut,
            GetProductUseCase getProductUseCase
    ){
        this.productManagementPersistenceOut = productManagementPersistenceOut;
        this.productManagementCloudinaryOut = productManagementCloudinaryOut;
        this.getProductUseCase = getProductUseCase;
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
    public void modifyProduct(ProductManagementModifyCommand command) throws Exception {
        try {
            Product oldProduct = getProductUseCase.getProduct(command.getId());
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
