package be.heh.dshop_backend.adapter.in.web;
import be.heh.dshop_backend.common.WebAdapter;
import be.heh.dshop_backend.core.domain.service.ProductManagementService;
import be.heh.dshop_backend.core.port.in.ProductManagementAddCommand;
import be.heh.dshop_backend.core.port.in.ProductManagementRemoveCommand;
import be.heh.dshop_backend.core.port.out.ProductManagementCloudinaryOut;
import be.heh.dshop_backend.core.port.out.ProductManagementPersistenceOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@WebAdapter
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ProductManagementController {
   private final ProductManagementPersistenceOut productManagementPersistenceOut;
   private final ProductManagementCloudinaryOut productManagementCloudinaryOut;

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
        final ProductManagementService productManagementService = new ProductManagementService(
                productManagementPersistenceOut,
                productManagementCloudinaryOut
        );

        productManagementService.addProduct(productManagementAddCommand);
        return new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
    }

    @CrossOrigin(origins="*")
    @DeleteMapping(path="/product/{id}", produces="application/json")
    @ResponseBody
    public ResponseEntity<String> removeProduct(@PathVariable int id) throws IOException {
        ProductManagementRemoveCommand productManagementRemoveCommand = new ProductManagementRemoveCommand(id);
        final ProductManagementService productManagementService = new ProductManagementService(
                productManagementPersistenceOut,
                productManagementCloudinaryOut
        );

        productManagementService.removeProduct(productManagementRemoveCommand);
        return new ResponseEntity<String>("Successfully removed", HttpStatus.OK);
    }
}
