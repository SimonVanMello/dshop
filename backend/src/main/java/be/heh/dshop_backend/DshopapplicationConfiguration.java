package be.heh.dshop_backend;

import be.heh.dshop_backend.adapter.out.cloudinary.ProductManagementCloudinaryAdapter;
import be.heh.dshop_backend.adapter.out.persistence.*;
import be.heh.dshop_backend.core.domain.service.GetProductService;
import be.heh.dshop_backend.core.domain.service.GetProductsService;
import be.heh.dshop_backend.core.domain.service.ProductManagementService;
import be.heh.dshop_backend.core.port.in.GetProductUseCase;
import be.heh.dshop_backend.core.port.in.GetProductsUseCase;
import be.heh.dshop_backend.core.port.in.ProductManagementUseCase;
import be.heh.dshop_backend.core.port.out.GetProductPersistenceOut;
import be.heh.dshop_backend.core.port.out.GetProductsPersistenceOut;
import be.heh.dshop_backend.core.port.out.ProductManagementCloudinaryOut;
import be.heh.dshop_backend.core.port.out.ProductManagementPersistenceOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories
public class DshopapplicationConfiguration {
    @Autowired
    private ProductManagementRepository productManagementRepository;
    @Autowired
    private GetProductsRepository getProductsRepository;
    @Autowired
    private GetProductRepository getProductRepository;

    @Bean
    public ProductManagementUseCase getProductManagementUseCase(
            ProductManagementPersistenceOut productManagementPersistenceOut,
            ProductManagementCloudinaryOut productManagementCloudinaryOut,
            GetProductsUseCase getProductsUseCase,
            GetProductUseCase getProductUseCase
    ){
        return new ProductManagementService(
            productManagementPersistenceOut,
            productManagementCloudinaryOut,
            getProductsUseCase,
            getProductUseCase
        );
    }

    @Bean
    public ProductManagementPersistenceOut getProductManagementPersistenceOut(){
        return new ProductManagementPersistenceAdapter(this.productManagementRepository);
    }

    @Bean
    public ProductManagementCloudinaryOut getProductManagementCloudinaryOut(){
        return new ProductManagementCloudinaryAdapter();
    }

    @Bean
    public GetProductsUseCase getGetProductsUseCase(GetProductsPersistenceOut getProductsPersistenceOut){
        return new GetProductsService(getProductsPersistenceOut);
    }

    @Bean
    public GetProductsPersistenceOut getGetProductsPersistenceOut(){
        return new GetProductsPersistenceAdapter(this.getProductsRepository);
    }

    @Bean
    public GetProductUseCase getGetProductUseCase(GetProductPersistenceOut getProductPersistenceOut){
        return new GetProductService(getProductPersistenceOut);
    }

    @Bean
    public GetProductPersistenceOut getGetProductPersistenceOut(){
        return new GetProductPersistenceAdapter(this.getProductRepository);
    }
}
