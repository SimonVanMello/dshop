package be.heh.dshop_backend.core.port.in;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import static be.heh.dshop_backend.common.Validation.validate;

public class ProductManagementAddCommand {
    @Getter
    @NotEmpty
    private final String name;

    @Getter
    @NotNull @Min(0)
    private final double price;

    @Getter
    @NotNull @Min(1)
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
