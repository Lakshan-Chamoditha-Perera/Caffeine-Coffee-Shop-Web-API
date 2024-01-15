package lk.caffeine.center_1.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: shan
 * Created: 1/15/24 11:45 PM
 */


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaristaDto {

    private String id;
    @NotNull(message = "Barista Name is mandatory")
    private String name;
    @NotNull(message = "Barista Address is mandatory")
    private String address;

    @Pattern(regexp = "\\d{10}", message = "Invalid Contact Number")
    @NotNull(message = "Barista Contact is mandatory")
    private String contact;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid Email")
    @NotNull(message = "Barista Email is mandatory")
    private String email;

    @Pattern(regexp = "\\d{9}[V|v|x|X]", message = "Invalid NIC")
    @NotNull(message = "Barista NIC is mandatory")
    private String nic;

    @Positive(message = "Salary must be positive")
    @NotNull(message = "Barista Salary is mandatory")
    private double salary;
}
