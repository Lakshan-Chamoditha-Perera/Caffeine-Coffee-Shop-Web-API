package lk.caffeine.center_1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

/**
 * Author: shan
 * Created: 1/15/24 8:17 PM
 */
@Entity
public class Coffee_Order_Detail {
    @Id
    @GeneratedValue
    private int id;

    @CreationTimestamp
    private Date date;
    @ManyToOne
    private Orders order;
    @ManyToOne
    private Coffee coffee;
}
