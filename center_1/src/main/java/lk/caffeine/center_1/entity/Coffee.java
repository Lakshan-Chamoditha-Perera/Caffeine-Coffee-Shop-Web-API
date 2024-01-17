package lk.caffeine.center_1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
    private String code;
    private String name;
    private String description;
    private Double price;
    private Double caffeineContent;

    @ManyToMany(mappedBy = "coffeeList", targetEntity = Orders.class)
    private List<Orders> ordersList = new ArrayList<>();

    @ManyToOne
    private Barista barista;
}
