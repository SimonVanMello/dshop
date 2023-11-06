package be.heh.dshop_backend.adapter.in.web;
import be.heh.dshop_backend.common.WebAdapter;
import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.in.ProductManagementAddCommand;
import be.heh.dshop_backend.core.port.in.ProductManagementUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@WebAdapter
@RestController
@RequiredArgsConstructor
//@CrossOrigin
public class ProductManagementController {
    @CrossOrigin(origins="*")
    @PostMapping(path="/product", consumes="multipart/form-data", produces="application/json")
    @ResponseBody
    public ResponseEntity<String> addProduct(
            @RequestParam(value="img") MultipartFile img,
            @RequestParam(value="name") String name,
            @RequestParam(value="price") double price,
            @RequestParam(value="quantity") int quantity) throws IOException {
        ProductManagementAddCommand productManagementAddCommand = new ProductManagementAddCommand(
                name,
                price,
                quantity,
                img.getBytes()
        );
        return new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
    }
}
