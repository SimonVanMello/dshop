package be.heh.dshop_backend;

import be.heh.dshop_backend.adapter.out.cloudinary.ProductManagementCloudinaryAdapter;
import be.heh.dshop_backend.adapter.out.persistence.*;
import be.heh.dshop_backend.core.domain.service.GetProductService;
import be.heh.dshop_backend.core.domain.service.GetProductsService;
import be.heh.dshop_backend.core.domain.service.ProductManagementService;
import be.heh.dshop_backend.core.port.in.GetProductUseCase;
import be.heh.dshop_backend.core.port.in.GetProductsUseCase;
import be.heh.dshop_backend.core.port.in.ProductManagementUseCase;
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
    public ProductManagementUseCase getProductManagementUseCase(){
        return new ProductManagementService(
            new ProductManagementPersistenceAdapter(this.productManagementRepository),
            new ProductManagementCloudinaryAdapter()
        );
    }

    @Bean
    public GetProductsUseCase getGetProductsUseCase(){
        return new GetProductsService(
            new GetProductsPersistenceAdapter(this.getProductsRepository)
        );
    }

    @Bean
    public GetProductUseCase getGetProductUseCase(){
        return new GetProductService(
            new GetProductPersistenceAdapter(this.getProductRepository)
        );
    }
}
