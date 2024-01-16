package lk.caffeine.center_1.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

/**
 * Author: shan
 * Created: 1/15/24 8:17 PM
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Coffee_Order_Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private Date date;

    @ManyToOne(cascade ={ CascadeType.PERSIST, CascadeType.PERSIST})
    @ToString.Exclude
    private Orders order;

    @ManyToOne
    private Coffee coffee;

    private int qty;
}
