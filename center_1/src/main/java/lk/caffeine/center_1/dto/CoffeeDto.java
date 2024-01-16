package lk.caffeine.center_1.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: shan
 * Created: 1/16/24 12:26 AM
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoffeeDto {

    private String cid;

    @NotNull(message = "Coffee Name is mandatory")
    private String name;

    @NotNull(message = "Coffee Description is mandatory")
    private String description;

    @NotNull(message = "Coffee Price is mandatory")
    @Positive(message = "Coffee Price must be positive")
    private double price;
    private double caffeineContent;

    @NotNull(message = "Barista cannot be null")
    private BaristaDto barista;
}
