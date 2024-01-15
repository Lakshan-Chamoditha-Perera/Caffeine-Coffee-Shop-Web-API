package lk.caffeine.center_1.service.impl;

import lk.caffeine.center_1.dto.BaristaDto;
import lk.caffeine.center_1.service.BaristaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: shan
 * Created: 1/15/24 11:51 PM
 */
@Service
@RequiredArgsConstructor
public class BaristaServiceImpl implements BaristaService {
    @Override
    public boolean save(BaristaDto dto) {
        return false;
    }

    @Override
    public boolean update(BaristaDto dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public BaristaDto search(String id) {
        return null;
    }

    @Override
    public List<BaristaDto> getAll() {
        return null;
    }
}
