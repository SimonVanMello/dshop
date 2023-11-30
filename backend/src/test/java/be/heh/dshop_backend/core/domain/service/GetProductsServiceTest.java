package be.heh.dshop_backend.core.domain.service;

import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.out.GetProductsPersistenceOut;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetProductsServiceTest {
    @Test
    public void getProductsReturnProductsFromGetProductsInPersistenceOut(){
        GetProductsPersistenceOut getProductsPersistenceOutMock = mock(GetProductsPersistenceOut.class);
        GetProductsService getProductsService = new GetProductsService(getProductsPersistenceOutMock);

        final ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(
                1,
                "name",
                12.3,
                "imgUrl",
                2
        ));
        when(getProductsPersistenceOutMock.getProducts()).thenReturn(products);

        ArrayList<Product> results = getProductsService.getProducts();
        assertEquals(results, products);
    }
}
