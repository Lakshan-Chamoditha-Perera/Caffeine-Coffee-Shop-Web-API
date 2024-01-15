package lk.caffeine.center_1.dto;

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
    private String id;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String nic;
    private double salary;
}
