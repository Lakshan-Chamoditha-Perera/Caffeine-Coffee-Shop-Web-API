package lk.caffeine.center_1.service;

import lk.caffeine.center_1.dto.OrdersDto;

/**
 * Author: shan
 * Created: 1/16/24 11:58 AM
 */
public interface OrdersService extends SuperService<OrdersDto, String> {
    String getOngoingOrderId();

    Integer getOrdersCount();

    Double getTotalIncome();
}
