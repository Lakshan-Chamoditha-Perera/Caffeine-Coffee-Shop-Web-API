package lk.caffeine.center_1.service.impl;

import lk.caffeine.center_1.dao.BaristaRepository;
import lk.caffeine.center_1.dto.BaristaDto;
import lk.caffeine.center_1.entity.Barista;
import lk.caffeine.center_1.service.BaristaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Author: shan
 * Created: 1/15/24 11:51 PM
 */
@Service
@RequiredArgsConstructor
public class BaristaServiceImpl implements BaristaService {
    private final BaristaRepository baristaRepository;
    private final ModelMapper mapper;

    @Override
    public boolean save(BaristaDto dto) {
        if (existsById(dto.getId())) {
            throw new RuntimeException("Barista already exists");
        }
        dto.setId(getOngoingBaristaId());
        baristaRepository.save(mapper.map(dto, Barista.class));
        return true;
    }

    @Override
    public boolean existsById(String id) {
        return baristaRepository.existsById(id);
    }

    @Override
    public String getOngoingBaristaId() {
        List<Barista> all = baristaRepository.findAll();
        if (all.isEmpty()) {
            return "B001";
        }
        String lastId = all.get(all.size() - 1).getId();
        String substring = lastId.substring(1);
        int id = Integer.parseInt(substring) + 1;
        return String.format("B%03d", id);
    }

    @Override
    public boolean update(BaristaDto dto) {
        Barista barista = mapper.map(dto, Barista.class);
        baristaRepository.save(barista);
        return true;
    }

    @Override
    public boolean delete(String id) {
        if (existsById(id)) {
            baristaRepository.deleteById(id);
            return true;
        }
        throw new RuntimeException("No such barista for delete..!");
    }

    @Override
    public BaristaDto search(String id) throws RuntimeException {
        Optional<Barista> byId = baristaRepository.findById(id);
        if (byId.isPresent()) {
            return mapper.map(byId.get(), BaristaDto.class);
        }
        throw new RuntimeException("No Barista for id: " + id);
    }

    @Override
    public List<BaristaDto> getAll() {
        List<BaristaDto> collect = baristaRepository.findAll().stream().map(barista -> mapper.map(barista, BaristaDto.class)).collect(Collectors.toList());
        return collect;
    }

}
