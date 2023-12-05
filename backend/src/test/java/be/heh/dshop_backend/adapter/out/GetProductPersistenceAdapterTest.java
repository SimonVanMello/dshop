package be.heh.dshop_backend.adapter.out;

import be.heh.dshop_backend.adapter.out.persistence.GetProductPersistenceAdapter;
import be.heh.dshop_backend.adapter.out.persistence.GetProductRepository;
import be.heh.dshop_backend.core.domain.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DataJdbcTest
@Import({GetProductPersistenceAdapter.class})
public class GetProductPersistenceAdapterTest {
    @Test
    public void getProductShouldReturnProductFromGetProductRepository(){
        GetProductRepository getProductRepositoryMock = mock(GetProductRepository.class);
        GetProductPersistenceAdapter getProductPersistenceAdapter = new GetProductPersistenceAdapter(
                getProductRepositoryMock
        );

        final int id = 1;
        Product product = new Product(
                1,
                "name",
                12.3,
                "imgUrl",
                2
        );
        when(getProductRepositoryMock.getProduct(id)).thenReturn(product);

        Product result = getProductPersistenceAdapter.getProduct(id);
        assertEquals(result, product);
    }
}
