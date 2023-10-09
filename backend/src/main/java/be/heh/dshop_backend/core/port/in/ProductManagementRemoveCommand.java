package be.heh.dshop_backend.core.port.in;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import static be.heh.dshop_backend.common.Validation.validate;

public class ProductManagementRemoveCommand {
    @Getter
    @NotNull @Min(0) private final int id;

    public ProductManagementRemoveCommand(int id){
        this.id = id;
        validate(this);
    }
}
