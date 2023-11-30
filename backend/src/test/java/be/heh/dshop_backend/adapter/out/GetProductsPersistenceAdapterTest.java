package be.heh.dshop_backend.adapter.out;

import be.heh.dshop_backend.adapter.out.persistence.GetProductsPersistenceAdapter;
import be.heh.dshop_backend.adapter.out.persistence.GetProductsRepository;
import be.heh.dshop_backend.core.domain.model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetProductsPersistenceAdapterTest {
    @Test
    public void getProductsShouldReturnProductsFromGetProductsRepository(){
        GetProductsRepository getProductsRepositoryMock = mock(GetProductsRepository.class);
        GetProductsPersistenceAdapter getProductPersistenceAdapter = new GetProductsPersistenceAdapter(
                getProductsRepositoryMock
        );

        final ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(
                1,
                "name",
                12.3,
                "imgUrl",
                2
        ));
        when(getProductsRepositoryMock.getProducts()).thenReturn(products);

        ArrayList<Product> results = getProductPersistenceAdapter.getProducts();
        assertEquals(results, products);
    }
}
