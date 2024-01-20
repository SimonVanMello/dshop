package be.heh.dshop_backend.core.domain.service;

import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.in.GetProductUseCase;
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
        GetProductUseCase getProductUseCaseMock = mock(GetProductUseCase.class);
        ProductManagementService pms = new ProductManagementService(
                productManagementPersistenceOutMock,
                productManagementCloudinaryOutMock,
                getProductUseCaseMock
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
    public void addProductShouldCallSaveImageInProductManagementCloudinaryOut(){
        ProductManagementPersistenceOut productManagementPersistenceOutMock = mock(ProductManagementPersistenceOut.class);
        ProductManagementCloudinaryOut productManagementCloudinaryOutMock = mock(ProductManagementCloudinaryOut.class);
        GetProductUseCase getProductUseCaseMock = mock(GetProductUseCase.class);
        ProductManagementService pms = new ProductManagementService(
                productManagementPersistenceOutMock,
                productManagementCloudinaryOutMock,
                getProductUseCaseMock
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
    public void removeProductShouldCallRemoveProductInProductManagementPersistenceOut(){
        ProductManagementPersistenceOut productManagementPersistenceOutMock = mock(ProductManagementPersistenceOut.class);
        ProductManagementCloudinaryOut productManagementCloudinaryOutMock = mock(ProductManagementCloudinaryOut.class);
        GetProductUseCase getProductUseCaseMock = mock(GetProductUseCase.class);
        ProductManagementService pms = new ProductManagementService(
                productManagementPersistenceOutMock,
                productManagementCloudinaryOutMock,
                getProductUseCaseMock
        );

        final int fakeId = 1;
        ProductManagementRemoveCommand command = mock(ProductManagementRemoveCommand.class);
        when(command.getId()).thenReturn(fakeId);

        pms.removeProduct(command);
        verify(productManagementPersistenceOutMock).removeProduct(fakeId);
    }

    @Test
    public void removeProductShouldCallDeleteImageInProductManagementCloudinaryOut(){
        ProductManagementPersistenceOut productManagementPersistenceOutMock = mock(ProductManagementPersistenceOut.class);
        ProductManagementCloudinaryOut productManagementCloudinaryOutMock = mock(ProductManagementCloudinaryOut.class);
        GetProductUseCase getProductUseCaseMock = mock(GetProductUseCase.class);
        ProductManagementService pms = new ProductManagementService(
                productManagementPersistenceOutMock,
                productManagementCloudinaryOutMock,
                getProductUseCaseMock
        );

        final int fakeId = 1;
        final String fakeImageName = "imageName";
        ProductManagementRemoveCommand command = mock(ProductManagementRemoveCommand.class);
        when(command.getId()).thenReturn(fakeId);

        when(productManagementPersistenceOutMock.removeProduct(fakeId)).thenReturn(fakeImageName);

        pms.removeProduct(command);
        verify(productManagementCloudinaryOutMock).deleteImage(fakeImageName);
    }
}
