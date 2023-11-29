package be.heh.dshop_backend;

import be.heh.dshop_backend.adapter.out.cloudinary.ProductManagementCloudinaryAdapter;
import be.heh.dshop_backend.adapter.out.persistence.ProductManagementPersistenceAdapter;
import be.heh.dshop_backend.adapter.out.persistence.ProductManagementRepository;
import be.heh.dshop_backend.core.domain.service.ProductManagementService;
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

    @Bean
    public ProductManagementUseCase getProductManagementUseCase(){
        return new ProductManagementService(
                new ProductManagementPersistenceAdapter(this.productManagementRepository),
                new ProductManagementCloudinaryAdapter()
        );
    }
}
