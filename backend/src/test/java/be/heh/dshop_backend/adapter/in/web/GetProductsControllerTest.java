package be.heh.dshop_backend.adapter.in.web;

import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.in.GetProductsUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = GetProductsController.class)
public class GetProductsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetProductsUseCase getProductsUseCase;

    @Test
    public void getProductsCallGetProductsInGetProductsUseCase() throws Exception{
        ArrayList<Product> productsList = new ArrayList<>();
        Product product = new Product(
            1,
            "name",
            12.3,
            "imgUrl",
            2
        );
        productsList.add(product);

        final String stringResult = "[{\"id\":1,\"name\":\"name\",\"price\":12.3,\"img\":null,\"imgUrl\":\"imgUrl\",\"quantity\":2}]";

        when(getProductsUseCase.getProducts()).thenReturn(productsList);
        mockMvc.perform(get("/product"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(stringResult)));
    }
}
