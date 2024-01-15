package lk.caffeine.center_1.api;

import jakarta.validation.Valid;
import lk.caffeine.center_1.dto.BaristaDto;
import lk.caffeine.center_1.dto.CustomerDto;
import lk.caffeine.center_1.service.BaristaService;
import lk.caffeine.center_1.util.payload.StandardMessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: shan
 * Created: 1/15/24 11:49 PM
 */

@RestController
@RequestMapping("/api/v1/barista")
@RequiredArgsConstructor
public class BaristaController {
    private final BaristaService baristaService;
    @GetMapping
    @RequestMapping("/getAll")
    public StandardMessageResponse getAll() {
        List<BaristaDto> baristaDtoList = baristaService.getAll();
        return new StandardMessageResponse(200, "Success", baristaDtoList);
    }


}
