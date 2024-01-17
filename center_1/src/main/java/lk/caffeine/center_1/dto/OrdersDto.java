package lk.caffeine.center_1.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: shan
 * Created: 1/16/24 11:57 AM
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrdersDto {
    private String id;
    @CreationTimestamp
    private Date date;
    private double total;
    private String customer_id;

    private List<CoffeeDto> coffeeList = new ArrayList<>();
}
