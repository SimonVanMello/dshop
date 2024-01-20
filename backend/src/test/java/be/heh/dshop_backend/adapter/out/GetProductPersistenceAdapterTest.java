package be.heh.dshop_backend.adapter.out;

import be.heh.dshop_backend.adapter.out.persistence.GetProductPersistenceAdapter;
import be.heh.dshop_backend.adapter.out.persistence.GetProductRepository;
import be.heh.dshop_backend.core.domain.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetProductPersistenceAdapterTest {

    @Test
    public void getProductShouldReturnProductFromGetProductRepository(){
        final GetProductRepository getProductRepository = mock(GetProductRepository.class);
        final GetProductPersistenceAdapter getProductPersistenceAdapter = new GetProductPersistenceAdapter(getProductRepository);

        final int id = 1;
        Product product = new Product(
                1,
                "name",
                12.3,
                "imgUrl",
                2
        );
        when(getProductRepository.getProduct(id)).thenReturn(product);

        Product result = getProductPersistenceAdapter.getProduct(id);
        assertEquals(result, product);
    }
}
