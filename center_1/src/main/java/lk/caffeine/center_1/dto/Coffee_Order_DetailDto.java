package lk.caffeine.center_1.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lk.caffeine.center_1.entity.Coffee;
import lk.caffeine.center_1.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

/**
 * Author: shan
 * Created: 1/16/24 12:21 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coffee_Order_DetailDto {
   private String order_id;
   private String coffee_id;
   private int qty;
}
