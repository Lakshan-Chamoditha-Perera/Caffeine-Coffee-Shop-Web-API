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
    private String orderId;

    @CreationTimestamp
    private Date date;

    private Double total;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.REFRESH},targetEntity = OrderDetail.class)
    @ToString.Exclude
    private List<OrderDetail> orderDetailList = new ArrayList<>();

}
