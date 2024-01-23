package be.heh.dshop_backend.adapter.out;

import be.heh.dshop_backend.adapter.out.persistence.ProductManagementPersistenceAdapter;
import be.heh.dshop_backend.adapter.out.persistence.ProductManagementRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ProductManagementPersistenceAdapterTest {
    private final ProductManagementRepository productManagementRepositoryMock = mock(ProductManagementRepository.class);
    @Test
    public void removeProductShouldCallRemoveProductFromProductManagementRepository(){
        final int fakeId = 1;
        ProductManagementPersistenceAdapter productManagementPersistenceAdapter = new ProductManagementPersistenceAdapter(this.productManagementRepositoryMock);
        productManagementPersistenceAdapter.removeProduct(fakeId);
        verify(productManagementRepositoryMock).deleteProductById(fakeId);
    }
}
