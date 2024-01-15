package lk.caffeine.center_1.api;

import jakarta.validation.Valid;
import lk.caffeine.center_1.dto.BaristaDto;
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

    @PostMapping
    @RequestMapping("/save")
    public ResponseEntity<StandardMessageResponse> save(@Valid @RequestBody BaristaDto baristaDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardMessageResponse(500, "Fail", bindingResult.getAllErrors()));
        }
        try {
            baristaService.save(baristaDto);
            return ResponseEntity.ok(new StandardMessageResponse(200, "Success", null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardMessageResponse(500, "Error ", e.getMessage()));
        }
    }

}
