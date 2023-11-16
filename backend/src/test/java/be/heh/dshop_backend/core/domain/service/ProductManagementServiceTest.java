package be.heh.dshop_backend.core.domain.service;

import be.heh.dshop_backend.adapter.out.persistence.ProductManagementPersistenceAdapter;
import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.in.ProductManagementAddCommand;
import be.heh.dshop_backend.core.port.in.ProductManagementRemoveCommand;
import be.heh.dshop_backend.core.port.out.ProductManagementCloudinaryOut;
import be.heh.dshop_backend.core.port.out.ProductManagementPersistenceOut;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class ProductManagementServiceTest {
    @Test
    public void addProductShouldCallAddProductInProductManagementPersistenceOut(){
        ProductManagementPersistenceOut productManagementPersistenceOutMock = mock(ProductManagementPersistenceOut.class);
        ProductManagementCloudinaryOut productManagementCloudinaryOutMock = mock(ProductManagementCloudinaryOut.class);
        ProductManagementService pms = new ProductManagementService(
                productManagementPersistenceOutMock,
                productManagementCloudinaryOutMock
        );

        ProductManagementAddCommand command = mock(ProductManagementAddCommand.class);
        when(command.getName()).thenReturn("productName");
        when(command.getPrice()).thenReturn(10.5);
        when(command.getQuantity()).thenReturn(1);
        when(command.getImage()).thenReturn("fakeImage".getBytes());

        Product p = pms.addProduct(command);
        verify(productManagementPersistenceOutMock).addProduct(p);
    }

    @Test
    public void addProductShouldCallSaveImageInProductManagementCloudinaryAdapter(){
        ProductManagementPersistenceOut productManagementPersistenceOutMock = mock(ProductManagementPersistenceOut.class);
        ProductManagementCloudinaryOut productManagementCloudinaryOutMock = mock(ProductManagementCloudinaryOut.class);
        ProductManagementService pms = new ProductManagementService(
                productManagementPersistenceOutMock,
                productManagementCloudinaryOutMock
        );

        ProductManagementAddCommand command = mock(ProductManagementAddCommand.class);
        when(command.getName()).thenReturn("productName");
        when(command.getPrice()).thenReturn(10.5);
        when(command.getQuantity()).thenReturn(1);
        when(command.getImage()).thenReturn("fakeImage".getBytes());

        Product p = pms.addProduct(command);
        verify(productManagementCloudinaryOutMock).saveImage(command);
    }
    
    @Test
    public void removeProductShouldCallRemoveProductInProductManagementOut(){
        ProductManagementPersistenceOut productManagementPersistenceOutMock = mock(ProductManagementPersistenceOut.class);
        ProductManagementCloudinaryOut productManagementCloudinaryOutMock = mock(ProductManagementCloudinaryOut.class);
        ProductManagementService pms = new ProductManagementService(
                productManagementPersistenceOutMock,
                productManagementCloudinaryOutMock
        );

        final int fakeId = 1;
        ProductManagementRemoveCommand command = mock(ProductManagementRemoveCommand.class);
        when(command.getId()).thenReturn(fakeId);

        pms.removeProduct(command);
        verify(productManagementPersistenceOutMock).removeProduct(fakeId);
    }
}
