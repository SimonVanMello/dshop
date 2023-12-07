package be.heh.dshop_backend.adapter.in.web;

import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.in.GetProductUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = GetProductController.class)
public class GetProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetProductUseCase getProductUseCase;

    @Test
    public void getProductCallGetProductInGetProductUseCase() throws Exception{
        Product product = new Product(
            1,
            "name",
            12.3,
            "imgUrl",
            2
        );
        final String stringResult = "{\"id\":1,\"name\":\"name\",\"price\":12.3,\"img\":null,\"imgUrl\":\"imgUrl\",\"quantity\":2}";

        when(getProductUseCase.getProduct(1)).thenReturn(product);

        mockMvc.perform(get("/product/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(stringResult)));
    }
}
