package be.heh.dshop_backend.adapter.out.persistence;

import be.heh.dshop_backend.core.domain.model.Product;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class ProductManagementRepository {
    private final JdbcTemplate jdbc;
    public ProductManagementRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public void storeProduct(Product product){
        final String query = "INSERT INTO Products (name,price,quantity,img) VALUES (?,?,?,?)";
        this.jdbc.update(query,
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getImgUrl());
    }

    public String getProductNameById(int id){
        final String query = "SELECT name FROM Products WHERE id=?";
        try {
            return this.jdbc.queryForObject(query, String.class, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void deleteProductById(int id){
        final String query = "DELETE FROM Products WHERE id=?";
        this.jdbc.update(query, id);
    }
}
