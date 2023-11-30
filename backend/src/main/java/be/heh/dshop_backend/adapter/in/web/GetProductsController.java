package be.heh.dshop_backend.adapter.in.web;

import be.heh.dshop_backend.common.WebAdapter;
import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.in.GetProductsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@WebAdapter
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class GetProductsController {
    private final GetProductsUseCase getProductsUseCase;

    @CrossOrigin(origins="*")
    @GetMapping(path="/product", produces="application/json")
    @ResponseBody
    public ResponseEntity<List<Product>> getProducts(){
        try{
            return new ResponseEntity<>(
                this.getProductsUseCase.getProducts(),
                    HttpStatus.OK
            );
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
