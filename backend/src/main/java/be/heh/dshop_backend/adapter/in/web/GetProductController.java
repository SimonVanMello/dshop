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
    @GetMapping(path={"/product/{id}", "/product/{id}/"}, produces="application/json")
    @ResponseBody
    public ResponseEntity getProduct(@PathVariable int id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.getProductUseCase.getProduct(id));
        } catch(Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
