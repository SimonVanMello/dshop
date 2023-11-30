package be.heh.dshop_backend.adapter.out.persistence;

import be.heh.dshop_backend.core.domain.model.Product;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GetProductRepository {
    private final JdbcTemplate jdbc;

    public GetProductRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public Product getProduct(int id){
        final String query = "SELECT * FROM Products WHERE id=?";
        Product[] products = {null};
        this.jdbc.query(
                query,
                (rs, rowNum) -> new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("img"),
                        rs.getInt("quantity")
                ),
                id
        ).forEach(product -> products[0] = product);
        if (products[0] == null){
            throw new EmptyResultDataAccessException(1);
        }
        return products[0];
    }
}
