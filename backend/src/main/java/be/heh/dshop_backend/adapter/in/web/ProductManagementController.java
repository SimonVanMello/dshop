package be.heh.dshop_backend.adapter.in.web;

import be.heh.dshop_backend.common.WebAdapter;
import be.heh.dshop_backend.core.port.in.ProductManagementAddCommand;
import be.heh.dshop_backend.core.port.in.ProductManagementModifyCommand;
import be.heh.dshop_backend.core.port.in.ProductManagementRemoveCommand;
import be.heh.dshop_backend.core.port.in.ProductManagementUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@WebAdapter
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ProductManagementController {
    private final ProductManagementUseCase productManagementUseCase;

    @CrossOrigin(origins="*")
    @PostMapping(path={"/product", "/product/"}, consumes="multipart/form-data", produces="application/json")
    @ResponseBody
    public ResponseEntity<String> addProduct(
            @RequestParam(value="img") MultipartFile img,
            @RequestParam(value="name") String name,
            @RequestParam(value="price") double price,
            @RequestParam(value="quantity") int quantity) {
        try{
            ProductManagementAddCommand productManagementAddCommand = new ProductManagementAddCommand(
                name,
                price,
                quantity,
                img.getBytes()
            );

            productManagementUseCase.addProduct(productManagementAddCommand);
            return new ResponseEntity<>("Successfully created", HttpStatus.CREATED);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins="*")
    @DeleteMapping(path={"/product/{id}", "/product/id/"}, produces="application/json")
    @ResponseBody
    public ResponseEntity<String> removeProduct(@PathVariable int id){
        try{
            ProductManagementRemoveCommand productManagementRemoveCommand = new ProductManagementRemoveCommand(id);

            productManagementUseCase.removeProduct(productManagementRemoveCommand);
            return new ResponseEntity<>("Successfully removed", HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins="*")
    @PutMapping(path={"/product/{id}", "/product/{id}/"}, consumes="multipart/form-data", produces="application/json")
    @ResponseBody
    public ResponseEntity<String> modifyProduct(
            @PathVariable int id,
            @RequestParam(value="img") MultipartFile img,
            @RequestParam(value="name") String name,
            @RequestParam(value="price") double price,
            @RequestParam(value="quantity") int quantity) {
        try{
            ProductManagementModifyCommand productManagementModifyCommand = new ProductManagementModifyCommand(
                    id,
                    name,
                    price,
                    quantity,
                    img.getBytes()
            );

            productManagementUseCase.modifyProduct(productManagementModifyCommand);
            return new ResponseEntity<>("Successfully created", HttpStatus.CREATED);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
