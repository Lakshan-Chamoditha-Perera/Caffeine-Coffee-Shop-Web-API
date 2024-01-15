package lk.caffeine.center_1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: shan
 * Created: 1/15/24 8:44 PM
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {

    @Pattern(regexp = "C\\d{3,}", message = "Invalid Customer ID")
    @NotNull(message = "Customer ID is mandatory")
    private String id;

    @NotNull(message = "Customer Name is mandatory")
    @Pattern(regexp = "[A-Za-z .]+", message = "Invalid Name")
    private String name;

    @Pattern(regexp = "[A-Za-z0-9 ,.]+", message = "Invalid Address")
    private String address;

    @Pattern(regexp = "\\d{10}", message = "Invalid Contact Number")
    private String contact;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid Email")
    private String email;

    @Pattern(regexp = "\\d{9}[V|v|x|X]", message = "Invalid NIC")
    private String nic;

    @Positive(message = "Salary must be positive")
    private double salary;
}
