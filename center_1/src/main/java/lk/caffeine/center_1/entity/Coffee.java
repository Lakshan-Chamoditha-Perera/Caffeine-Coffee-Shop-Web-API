package lk.caffeine.center_1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Author: shan
 * Created: 1/15/24 8:11 PM
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coffee {
    @Id
    private String id;

    private String name;
    private String description;
    private double price;
    private double caffeineContent;

    @OneToMany(mappedBy = "coffee")
    @ToString.Exclude
    private List<Coffee_Order_Detail> coffee_order_detail;
    @ManyToOne
    private Barista barista;
}
