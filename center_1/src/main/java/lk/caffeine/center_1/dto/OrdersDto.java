package lk.caffeine.center_1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * Author: shan
 * Created: 1/16/24 11:57 AM
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdersDto {
    private String id;
    private Date date;
    private double total;
    private String customer_id;
    private Coffee_Order_DetailDto[] coffee_order_detail;
}
