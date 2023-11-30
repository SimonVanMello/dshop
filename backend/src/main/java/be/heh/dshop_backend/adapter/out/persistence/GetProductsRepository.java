package be.heh.dshop_backend.adapter.out.persistence;

import be.heh.dshop_backend.core.domain.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

@Repository
public class GetProductsRepository {
    private final JdbcTemplate jdbc;
    public GetProductsRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public ArrayList<Product> getProducts(){
        ArrayList<Product> products = new ArrayList<Product>();
        final String query = "SELECT * FROM Products";
        this.jdbc.query(
                query,
                (rs, rowNum) -> new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("img"),
                        rs.getInt("quantity")
                )
        ).forEach(product -> products.add(product));

        return products;
    }
}
