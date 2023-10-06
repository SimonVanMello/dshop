package be.heh.dshop_backend.core.port.in;

public interface ProductManagementUseCase {
    public void addProduct(String product);
    public void modifyProduct(String product);
    public void removeProduct(int productId);
}
