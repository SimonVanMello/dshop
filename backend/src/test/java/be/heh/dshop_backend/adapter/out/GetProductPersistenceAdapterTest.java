package be.heh.dshop_backend.adapter.out;

import be.heh.dshop_backend.adapter.out.persistence.GetProductPersistenceAdapter;
import be.heh.dshop_backend.adapter.out.persistence.GetProductRepository;
import be.heh.dshop_backend.core.domain.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
