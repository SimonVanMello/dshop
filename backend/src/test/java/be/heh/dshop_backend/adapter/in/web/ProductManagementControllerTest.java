package be.heh.dshop_backend.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockPart;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
//@WebMvcTest(controllers = ProductManagementController.class)
public class ProductManagementControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void addNewProductReturns201() throws Exception{
        MockPart name = new MockPart("name", "productName".getBytes());
        MockPart price = new MockPart("price", "12.4".getBytes());
        MockPart quantity = new MockPart("quantity", "3".getBytes());
        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "image.png",
                MediaType.IMAGE_PNG_VALUE,
                "fakeImage".getBytes()
        );

        MockMvc mockMvc
                = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/product")
                .file(file)
                .part(name, price, quantity)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // TODO: find out why this returns 400
    }
}
