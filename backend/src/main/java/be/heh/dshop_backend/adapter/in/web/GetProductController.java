package be.heh.dshop_backend.adapter.in.web;

import be.heh.dshop_backend.common.WebAdapter;
import be.heh.dshop_backend.core.domain.model.Product;
import be.heh.dshop_backend.core.port.in.GetProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class GetProductController {
    private final GetProductUseCase getProductUseCase;

    @CrossOrigin(origins="*")
    @GetMapping(path="/product/{id}", produces="application/json")
    @ResponseBody
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        try{
            return new ResponseEntity<>(
                    this.getProductUseCase.getProduct(id),
                    HttpStatus.OK
            );
        } catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
