package lk.caffeine.center_1.dao;

import lk.caffeine.center_1.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * Author: shan
 * Created: 1/16/24 12:25 AM
 */
@Repository
@EnableJpaRepositories
public interface CoffeeRepository extends JpaRepository<Coffee,String> {
    Coffee findCoffeeByCid(String cid);


}
