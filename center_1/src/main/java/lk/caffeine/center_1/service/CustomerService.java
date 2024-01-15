package lk.caffeine.center_1.service;

import lk.caffeine.center_1.dto.CustomerDto;

/**
 * Author: shan
 * Created: 1/15/24 10:47 PM
 */
public interface CustomerService extends SuperService<CustomerDto, String> {
    boolean existsById(String id);

    String getOngoingCustomerId();
}
