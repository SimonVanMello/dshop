package be.heh.dshop_backend.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ProductManagementControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void contextLoad(){}

    @Test
    public void addNewProductWithInvalidImageShouldReturns400() throws Exception{
        MockMultipartFile file
                = new MockMultipartFile(
                "img",
                "image.png",
                MediaType.IMAGE_PNG_VALUE,
                "fakeImage".getBytes()
        );

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/product")
                .file(file)
                .param("name", "productName")
                .param("price", "12.4")
                .param("quantity", "3")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));

    }

    @Test
    public void removeProductWithInvalidIdShouldReturns400() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(delete("/product/{id}", 0)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));
    }

    // This actually delete the product with id 8 from the database
    // So if you want to test this, you need to change the id
    @Test
    public void removeProductWithValidIdShouldReturns200() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(delete("/product/{id}", 8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }
}
