package lk.caffeine.center_1.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

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

    private OrderDetailDto[] coffee_order_detail;
}
