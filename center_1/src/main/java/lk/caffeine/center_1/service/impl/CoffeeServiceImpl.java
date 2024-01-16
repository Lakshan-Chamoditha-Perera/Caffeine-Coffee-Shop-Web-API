package lk.caffeine.center_1.service.impl;

import lk.caffeine.center_1.dao.CoffeeRepository;
import lk.caffeine.center_1.dto.CoffeeDto;
import lk.caffeine.center_1.entity.Coffee;
import lk.caffeine.center_1.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: shan
 * Created: 1/16/24 12:43 AM
 */

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {
    private final CoffeeRepository coffeeRepository;
    private final ModelMapper mapper;

    @Override
    public boolean save(CoffeeDto dto) throws RuntimeException {
        if (coffeeRepository.existsById(dto.getId())) {
            throw new RuntimeException("Coffee already exists");
        }
        Coffee map = mapper.map(dto, Coffee.class);
        coffeeRepository.save(map);
        return true;
    }

    @Override
    public boolean update(CoffeeDto dto) {
        return false;
    }

    @Override
    public boolean delete(String id) throws RuntimeException {
        if (coffeeRepository.existsById(id)) {
            coffeeRepository.deleteById(id);
            return true;
        }
        throw new RuntimeException("No Coffee for delete ID: " + id);
    }

    @Override
    public CoffeeDto search(String id) {
        return null;
    }

    @Override
    public List<CoffeeDto> getAll() {
        List<Coffee> coffeeRepositoryAll = coffeeRepository.findAll();
        return coffeeRepositoryAll.stream().map(c -> mapper.map(c, CoffeeDto.class)).toList();
    }
}
