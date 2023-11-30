package be.heh.dshop_backend.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
