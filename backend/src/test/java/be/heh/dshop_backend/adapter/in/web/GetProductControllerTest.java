package be.heh.dshop_backend.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GetProductControllerTest {
    @Autowired
    private GetProductController controller;

    @Test
    public void contextLoad(){
        assertThat(this.controller).isNotNull();
    }

    @Test
    public void getProductShouldReturnAProduct(){

    }
}
