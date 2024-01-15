package lk.caffeine.center_1.dao;

import lk.caffeine.center_1.entity.Barista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * Author: shan
 * Created: 1/15/24 11:50 PM
 */
@Repository
@EnableJpaRepositories
public interface BaristaRepository extends JpaRepository<Barista, String> {
}
