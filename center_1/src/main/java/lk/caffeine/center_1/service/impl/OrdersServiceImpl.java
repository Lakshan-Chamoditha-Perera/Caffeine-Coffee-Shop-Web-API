package lk.caffeine.center_1.service.impl;

import lk.caffeine.center_1.dao.CoffeeRepository;
import lk.caffeine.center_1.dao.CustomerRepository;
import lk.caffeine.center_1.dao.OrdersRepository;
import lk.caffeine.center_1.dto.OrderDetailDto;
import lk.caffeine.center_1.dto.OrdersDto;
import lk.caffeine.center_1.entity.Coffee;
import lk.caffeine.center_1.entity.OrderDetail;
import lk.caffeine.center_1.entity.Customer;
import lk.caffeine.center_1.entity.Orders;
import lk.caffeine.center_1.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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
    public boolean save(OrdersDto dto) {
//        Orders orders = new Orders();
//        orders.setOrderId(dto.getId());
//        orders.setTotal(dto.getTotal());
//
////        set customer
//        Customer customerById = customerRepository.findCustomerById(dto.getCustomer_id());
//        orders.setCustomer(customerById);
//
////        set coffee order details
//        System.out.println(Arrays.toString(dto.getCoffee_order_detail()));
//        System.out.println("---------------------------------------------------------------------------------------");
//        for (OrderDetailDto coffeeOrderDetailDto : dto.getCoffee_order_detail()) {
//            OrderDetail coffeeOrderDetail = toCODEntity(coffeeOrderDetailDto, orders);
//            System.out.println(coffeeOrderDetail);
//            orders.getOrderDetails().add(coffeeOrderDetail);
//        }
//        System.out.println("---------------------------------------------------------------------------------------");
//        ordersRepository.save(orders);
        return true;
    }

    private OrderDetail toCODEntity(OrderDetailDto coffeeOrderDetailDto, Orders order) {
        OrderDetail coffeeOrderDetail = new OrderDetail();
        coffeeOrderDetail.setOrder(order);

        Coffee coffeeByCid = coffeeRepository.findCoffeeByCid(coffeeOrderDetailDto.getCoffeeCode());
        coffeeOrderDetail.setCoffee(coffeeByCid);

        coffeeOrderDetail.setQty(coffeeOrderDetailDto.getQty());
        return coffeeOrderDetail;
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
