package be.heh.dshop_backend.adapter.in.web;

import be.heh.dshop_backend.common.WebAdapter;
import be.heh.dshop_backend.core.port.in.GetProductsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class GetProductsController {
    private final GetProductsUseCase getProductsUseCase;

    @CrossOrigin(origins="*")
    @GetMapping(path={"/product", "/product/"}, produces="application/json")
    @ResponseBody
    public ResponseEntity getProducts(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.getProductsUseCase.getProducts());
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
