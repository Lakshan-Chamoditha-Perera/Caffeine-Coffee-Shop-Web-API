package lk.caffeine.center_1.service.impl;

import lk.caffeine.center_1.dao.CustomerRepository;
import lk.caffeine.center_1.dto.CustomerDto;
import lk.caffeine.center_1.entity.Customer;
import lk.caffeine.center_1.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Author: shan
 * Created: 1/15/24 10:47 PM
 */


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;

    @Override
    public boolean save(CustomerDto dto) throws RuntimeException {
        if (existsById(dto.getId())) {
            throw new RuntimeException("Customer already exists");
        }
        dto.setId(getOngoingCustomerId());
        customerRepository.save(mapper.map(dto, Customer.class));
        return true;
    }

    @Override
    public boolean update(CustomerDto dto) {
        Customer customer = mapper.map(dto, Customer.class);
        customerRepository.save(customer);
        return true;
    }

    @Override
    public boolean delete(String id) throws RuntimeException {
        if (existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        throw new RuntimeException("No such customer for delete..!");
    }

    @Override
    public CustomerDto search(String id) throws RuntimeException {
        Optional<Customer> byId = customerRepository.findById(id);
        if (byId.isPresent()) {
            return mapper.map(byId.get(), CustomerDto.class);
        }
        throw new RuntimeException("No customer for id: " + id);
    }

    @Override
    public List<CustomerDto> getAll() {
        List<CustomerDto> collect = customerRepository.findAll().stream().map(customer -> mapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public boolean existsById(String id) {
        return customerRepository.existsById(id);
    }

    @Override
    public String getOngoingCustomerId() {
        List<Customer> all = customerRepository.findAll();
        if (all.isEmpty()) {
            return "C001";
        }
        String lastId = all.get(all.size() - 1).getId();
        String substring = lastId.substring(1);
        int id = Integer.parseInt(substring) + 1;
        return String.format("C%03d", id);
    }
}
