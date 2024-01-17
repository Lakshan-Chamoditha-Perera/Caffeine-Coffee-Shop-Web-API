package lk.caffeine.center_1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: shan
 * Created: 1/16/24 12:21 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
   private String orderId;
   private String coffeeCode;
   private Integer qty;
}
