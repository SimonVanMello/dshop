package be.heh.dshop_backend.adapter.in.web;

import be.heh.dshop_backend.core.domain.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GetProductsControllerTest {
    @Autowired
    private GetProductsController controller;

    @Test
    public void contextLoad(){
        assertThat(this.controller).isNotNull();
    }

    @Test
    public void getProductsShouldReturnAnArray(){
        assertThat(this.controller.getProducts()).getClass().isArray();
    }

    @Test
    public void getProductsShouldReturnAnArrayOfProductsOrEmptyArray(){
        ResponseEntity response =  this.controller.getProducts();
        Object productsObject = response.getBody().getClass();
        List<Object> products = Arrays.asList(productsObject);
        if (products.size() > 0){
            assertThat(products.get(0)).getClass().isInstance(Product.class);
        } else{
            assertThat(products).getClass().isArray();
        }
    }
}
