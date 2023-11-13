package be.heh.dshop_backend.adapter.out.persistence;

import be.heh.dshop_backend.core.domain.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductManagementRepository {
    private final JdbcTemplate jdbc;
    public ProductManagementRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public void storeProduct(Product product){
        String sql = "INSERT INTO Products (name,price,quantity,img) VALUES (?,?,?,?)";
        jdbc.update(sql,
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getImgUrl());
    }
}
