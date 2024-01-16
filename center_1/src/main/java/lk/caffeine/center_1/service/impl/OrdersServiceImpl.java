package lk.caffeine.center_1.service.impl;

import lk.caffeine.center_1.dao.OrdersRepository;
import lk.caffeine.center_1.dto.OrdersDto;
import lk.caffeine.center_1.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: shan
 * Created: 1/16/24 11:58 AM
 */
@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;

    @Override
    public boolean save(OrdersDto dto) {
        return false;
    }

    @Override
    public boolean update(OrdersDto dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public OrdersDto search(String id) {
        return null;
    }

    @Override
    public List<OrdersDto> getAll() {
        return null;
    }


    @Override
    public String getOngoingOrderId() {
        String lastOrderId = ordersRepository.getLastOrderId();
        return lastOrderId == null ? "O001" : "O" + (Integer.parseInt(lastOrderId.replace("O", "")) + 1);
    }
}
