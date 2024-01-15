package lk.caffeine.center_1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: shan
 * Created: 1/15/24 8:08 PM
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private String id;
    private String name;
    private String address;
    private String contact;
    private String email;

    @CreationTimestamp
    private Date date;

    @OneToMany(mappedBy = "customer")
    private List<Orders> orders = new ArrayList<>();
}
