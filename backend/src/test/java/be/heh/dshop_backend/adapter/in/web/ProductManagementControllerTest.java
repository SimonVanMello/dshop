package be.heh.dshop_backend.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.fail;
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
    public void addNewProductWithValidParamsShouldReturns200() throws Exception{
        // Start by downloading an image from the internet
        byte[] imageBytes = null;
        try{
            String imageUrl = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";
            InputStream in = new URL(imageUrl).openStream();
            Path outputPath = Files.createTempFile("downloaded", ".png");
            Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
            imageBytes = Files.readAllBytes(outputPath);
        } catch (Exception e){
            fail("Failed to download image");
        }

        MockMultipartFile file
                = new MockMultipartFile(
                "img",
                "image.png",
                MediaType.IMAGE_PNG_VALUE,
                imageBytes
        );

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/product")
                .file(file)
                .param("name", "productName")
                .param("price", "12.4")
                .param("quantity", "3")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(201));
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
