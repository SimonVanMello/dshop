package be.heh.dshop_backend.core.port.in;

public interface ProductManagementUseCase {
    public void addProduct(ProductManagementAddCommand command);
    public void modifyProduct(ProductManagementModifyCommand command);
    public void removeProduct(ProductManagementRemoveCommand command);
}
