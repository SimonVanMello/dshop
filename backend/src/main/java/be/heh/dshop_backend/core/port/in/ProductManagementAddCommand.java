package be.heh.dshop_backend.core.port.in;

import jakarta.validation.constraints.*;
import lombok.Getter;

import static be.heh.dshop_backend.common.Validation.validate;

public class ProductManagementAddCommand {
    @Getter
    @NotEmpty
    @Size(min = 2, message = "too short")
    @Size(max = 200, message = "too long")
    private final String name;

    @Getter
    @NotNull @Min(0) @Max(99999999)
    private final double price;

    @Getter
    @NotNull @Min(1)  @Max(99999999)
    private final int quantity;

    @Getter
    @NotEmpty
    private final byte[] image;

    public ProductManagementAddCommand(String name, double price, int quantity, byte[] image){
        this.name = name;
        this.price = Math.round(price*100)/100.00;
        this.quantity = quantity;
        this.image = image;
        validate(this);
    }
}
