package be.heh.dshop_backend.core.domain.service;

import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.in.*;
import be.heh.dshop_backend.core.port.out.ProductManagementCloudinaryOut;
import be.heh.dshop_backend.core.port.out.ProductManagementPersistenceOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class ProductManagementServiceTest {
    private final ProductManagementPersistenceOut productManagementPersistenceOutMock = mock(ProductManagementPersistenceOut.class);
    private final ProductManagementCloudinaryOut productManagementCloudinaryOutMock = mock(ProductManagementCloudinaryOut.class);
    private final GetProductsUseCase getProductsUseCaseMock = mock(GetProductsUseCase.class);
    private final GetProductUseCase getProductUseCaseMock = mock(GetProductUseCase.class);
    private final ProductManagementService pms = new ProductManagementService(
            this.productManagementPersistenceOutMock,
            this.productManagementCloudinaryOutMock,
            this.getProductsUseCaseMock,
            this.getProductUseCaseMock
    );

    @Test
    public void addProductShouldCallAddProductInProductManagementPersistenceOut(){
        ProductManagementAddCommand command = mock(ProductManagementAddCommand.class);
        when(command.getName()).thenReturn("productName");
        when(command.getPrice()).thenReturn(10.5);
        when(command.getQuantity()).thenReturn(1);
        when(command.getImage()).thenReturn("fakeImage".getBytes());

        Product p = pms.addProduct(command);
        verify(productManagementPersistenceOutMock).addProduct(p);
    }

    @Test
    public void addProductShouldCallSaveImageInProductManagementCloudinaryOut(){
        ProductManagementAddCommand command = mock(ProductManagementAddCommand.class);
        when(command.getName()).thenReturn("productName");
        when(command.getPrice()).thenReturn(10.5);
        when(command.getQuantity()).thenReturn(1);
        when(command.getImage()).thenReturn("fakeImage".getBytes());

        pms.addProduct(command);
        verify(productManagementCloudinaryOutMock).saveImage(command);
    }

    @Test
    public void removeProductShouldCallRemoveProductInProductManagementPersistenceOut(){
        final int fakeId = 1;
        ProductManagementRemoveCommand command = mock(ProductManagementRemoveCommand.class);
        when(command.getId()).thenReturn(fakeId);

        pms.removeProduct(command);
        verify(productManagementPersistenceOutMock).removeProduct(fakeId);
    }

    @Test
    public void removeProductShouldCallDeleteImageInProductManagementCloudinaryOut(){
        final int fakeId = 1;
        final String fakeImageName = "imageName";
        ProductManagementRemoveCommand command = mock(ProductManagementRemoveCommand.class);
        when(command.getId()).thenReturn(fakeId);

        when(productManagementPersistenceOutMock.removeProduct(fakeId)).thenReturn(fakeImageName);

        pms.removeProduct(command);
        verify(productManagementCloudinaryOutMock).deleteImage(fakeImageName);
    }

    @Test
    public void modifyProductShouldCallModifyProductInProductManagementPersistenceOut(){
        ProductManagementModifyCommand command = mock(ProductManagementModifyCommand.class);
        when(command.getId()).thenReturn(1);
        when(command.getName()).thenReturn("productName");
        when(command.getPrice()).thenReturn(10.5);
        when(command.getQuantity()).thenReturn(1);
        when(command.getImage()).thenReturn("fakeImage".getBytes());
        try{
            Product p = pms.modifyProduct(command);
            verify(productManagementPersistenceOutMock).modifyProduct(p);
        } catch (Exception e){
            fail(e.toString());
        }
    }
    @Test
    public void modifyProductShouldCallModifyImageInProductManagementCloudinaryOut(){
        ProductManagementModifyCommand command = mock(ProductManagementModifyCommand.class);
        when(command.getId()).thenReturn(0);
        when(command.getName()).thenReturn("productName");
        when(command.getPrice()).thenReturn(10.5);
        when(command.getQuantity()).thenReturn(1);
        when(command.getImage()).thenReturn("fakeImage".getBytes());
        try{
            pms.modifyProduct(command);
            verify(productManagementCloudinaryOutMock).modifyImage(command);
        } catch (Exception e){
            fail(e.toString());
        }
    }
}
