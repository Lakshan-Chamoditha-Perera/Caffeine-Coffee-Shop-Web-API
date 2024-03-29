package lk.caffeine.center_1.dao;

import lk.caffeine.center_1.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * Author: shan
 * Created: 1/16/24 11:56 AM
 */

@Repository
@EnableJpaRepositories
public interface OrdersRepository extends JpaRepository<Orders, String> {
    @Query(value = "SELECT MAX (orderId) FROM Orders")
    String getLastOrderId();

    @Query(value = "SELECT COUNT (orderId) FROM Orders")
    Integer getOrdersCount();

    @Query(value = "SELECT SUM (total) FROM Orders")
    Double getTotalIncome();
}
