package lk.caffeine.center_1.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: shan
 * Created: 1/15/24 8:13 PM
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Orders {
    @Id
    private String order_id;

    @CreationTimestamp
    private Date date;

    private double total;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.REFRESH},targetEntity = Coffee_Order_Detail.class)
    private List<Coffee_Order_Detail> coffee_order_details_List = new ArrayList<>();

}
