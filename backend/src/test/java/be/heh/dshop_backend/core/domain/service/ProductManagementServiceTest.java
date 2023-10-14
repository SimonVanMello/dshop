package be.heh.dshop_backend.core.domain.service;

import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.in.ProductManagementAddCommand;
import be.heh.dshop_backend.core.port.in.ProductManagementRemoveCommand;
import be.heh.dshop_backend.core.port.out.ProductManagementOut;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class ProductManagementServiceTest {
    @Test
    public void addProductShouldCallAddProductInProductManagementOut(){
        ProductManagementOut mock = mock(ProductManagementOut.class);
        ProductManagementService pms = new ProductManagementService(mock);

        ProductManagementAddCommand command = mock(ProductManagementAddCommand.class);
        when(command.getName()).thenReturn("productName");
        when(command.getPrice()).thenReturn(10.5);
        when(command.getQuantity()).thenReturn(1);
        when(command.getImage()).thenReturn("fakeImage".getBytes());

        Product p = pms.addProduct(command);
        verify(mock).addProduct(p);
    }

    @Test
    public void removeProductShouldCallRemoveProductInProductManagementOut(){
        ProductManagementOut mock = mock(ProductManagementOut.class);
        ProductManagementService pms = new ProductManagementService(mock);

        final int fakeId = 72917300;
        ProductManagementRemoveCommand command = mock(ProductManagementRemoveCommand.class);
        when(command.getId()).thenReturn(fakeId);

        pms.removeProduct(command);
        verify(mock).removeProduct(fakeId);
    }
}
