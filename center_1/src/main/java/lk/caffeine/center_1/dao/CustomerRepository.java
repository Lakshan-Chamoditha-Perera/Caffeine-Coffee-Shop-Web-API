package lk.caffeine.center_1.dao;

import lk.caffeine.center_1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * Author: shan
 * Created: 1/15/24 10:52 PM
 */

@Repository
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
