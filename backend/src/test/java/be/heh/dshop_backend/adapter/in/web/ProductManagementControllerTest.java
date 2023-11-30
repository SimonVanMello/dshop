package be.heh.dshop_backend.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockPart;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ProductManagementControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

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
}
