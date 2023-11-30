package be.heh.dshop_backend.core.domain.service;

import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.out.GetProductPersistenceOut;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

public class GetProductServiceTest {
    @Test
    public void getProductShouldReturnProductFromGetProductInPersistenceOut(){
        GetProductPersistenceOut getProductPersistenceOutMock = mock(GetProductPersistenceOut.class);
        GetProductService getProductService = new GetProductService(getProductPersistenceOutMock);

        final int id = 1;
        Product product = new Product(
                1,
                "name",
                12.3,
                "imgUrl",
                2
        );
        when(getProductPersistenceOutMock.getProduct(id)).thenReturn(product);

        Product result = getProductService.getProduct(id);
        assertEquals(product, result);
    }
}
