package lk.caffeine.center_1.dto;

import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lk.caffeine.center_1.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: shan
 * Created: 1/16/24 12:26 AM
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoffeeDto {

    private String code;

    @NotNull(message = "Coffee Name is mandatory")
    private String name;

    @NotNull(message = "Coffee Description is mandatory")
    private String description;

    @NotNull(message = "Coffee Price is mandatory")
    @Positive(message = "Coffee Price must be positive")
    private Double price;
    private Double caffeineContent;

    @NotNull(message = "Barista cannot be null")
    private BaristaDto barista;

    @ToString.Exclude
    private List<OrdersDto> ordersList = new ArrayList<>();

}
