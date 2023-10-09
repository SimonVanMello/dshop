package be.heh.dshop_backend.core.port.in;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import static be.heh.dshop_backend.common.Validation.validate;

public class ProductManagementModifyCommand {
    @Getter
    @NotNull @Min(0) private final int id;

    @Getter
    @NotNull
    private final String name;

    @Getter
    @NotNull @Min(0) private final double price;

    @Getter
    @NotNull @Min(1) private final int quantity;

    @Getter
    @NotNull private final byte[] image;

    public ProductManagementModifyCommand(int id, String name, double price, int quantity, byte[] image){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        validate(this);
    }
}
