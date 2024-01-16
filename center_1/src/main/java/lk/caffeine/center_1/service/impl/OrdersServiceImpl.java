package lk.caffeine.center_1.service.impl;

import lk.caffeine.center_1.dao.CoffeeRepository;
import lk.caffeine.center_1.dao.CustomerRepository;
import lk.caffeine.center_1.dao.OrdersRepository;
import lk.caffeine.center_1.dto.Coffee_Order_DetailDto;
import lk.caffeine.center_1.dto.OrdersDto;
import lk.caffeine.center_1.entity.Coffee;
import lk.caffeine.center_1.entity.Coffee_Order_Detail;
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
        Orders orders = new Orders();
        orders.setOrder_id(dto.getId());
        orders.setTotal(dto.getTotal());

//        set customer
        Customer customerById = customerRepository.findCustomerById(dto.getCustomer_id());
        orders.setCustomer(customerById);

//        set coffee order details
        System.out.println(Arrays.toString(dto.getCoffee_order_detail()));
        System.out.println("---------------------------------------------------------------------------------------");
        for (Coffee_Order_DetailDto coffeeOrderDetailDto : dto.getCoffee_order_detail()) {
            Coffee_Order_Detail coffeeOrderDetail = toCODEntity(coffeeOrderDetailDto, orders);
            System.out.println(coffeeOrderDetail);
            orders.getCoffee_order_details_List().add(coffeeOrderDetail);
        }
        System.out.println("---------------------------------------------------------------------------------------");
        ordersRepository.save(orders);
        return true;
    }

    private Coffee_Order_Detail toCODEntity(Coffee_Order_DetailDto coffeeOrderDetailDto, Orders order) {
        Coffee_Order_Detail coffeeOrderDetail = new Coffee_Order_Detail();
        coffeeOrderDetail.setOrder(order);

        Coffee coffeeByCid = coffeeRepository.findCoffeeByCid(coffeeOrderDetailDto.getCoffee_id());
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
