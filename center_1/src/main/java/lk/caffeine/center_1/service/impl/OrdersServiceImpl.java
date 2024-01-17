package lk.caffeine.center_1.service.impl;

import lk.caffeine.center_1.dao.CoffeeRepository;
import lk.caffeine.center_1.dao.CustomerRepository;
import lk.caffeine.center_1.dao.OrdersRepository;
import lk.caffeine.center_1.dto.OrdersDto;
import lk.caffeine.center_1.entity.Coffee;
import lk.caffeine.center_1.entity.Customer;
import lk.caffeine.center_1.entity.Orders;
import lk.caffeine.center_1.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Author: shan
 * Created: 1/16/24 11:58 AM
 */
@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;
    private final CoffeeRepository coffeeRepository;
    private final CustomerRepository customerRepository;

    @Override
    public boolean save(OrdersDto ordersDto) throws RuntimeException {
        Optional<Customer> customer = customerRepository.findById(ordersDto.getCustomer_id());
        if (!customer.isPresent()) {
            throw new RuntimeException("No customer for id: " + ordersDto.getCustomer_id());
        }

        Orders orders = new Orders();
        orders.setOrderId(ordersDto.getId());
        orders.setDate(ordersDto.getDate());
        orders.setTotal(ordersDto.getTotal());
        orders.setCustomer(customer.get());

        List<Coffee> coffeeList = new ArrayList<>();
        for (int i = 0; i < ordersDto.getCoffeeList().size(); i++) {
            Optional<Coffee> coffee = coffeeRepository.findById(ordersDto.getCoffeeList().get(i).getCode());
            if (!coffee.isPresent())
                throw new RuntimeException("No coffee for id: " + ordersDto.getCoffeeList().get(i).getCode());
            coffeeList.add(coffee.get());
        }

        orders.setCoffeeList(coffeeList);
        ordersRepository.save(orders);
        return true;
    }


    @Override
    public boolean update(OrdersDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
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

    @Override
    public int getOrdersCount() {
        return ordersRepository.getOrdersCount();
    }
}
