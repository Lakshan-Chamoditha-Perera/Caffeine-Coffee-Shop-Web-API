package lk.caffeine.center_1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Author: shan
 * Created: 1/15/24 8:22 PM
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Barista {
    @Id
    private String id;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String nic;
    private double salary;

    @OneToMany(mappedBy = "barista")
    @ToString.Exclude
    private List<Coffee> coffee;
}
