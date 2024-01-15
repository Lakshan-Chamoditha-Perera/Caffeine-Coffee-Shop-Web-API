package lk.caffeine.center_1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

/**
 * Author: shan
 * Created: 1/15/24 8:13 PM
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    @Id
    private String id;
    private Date date;
    private double total;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<Coffee_Order_Detail> coffee_order_detail;
}
