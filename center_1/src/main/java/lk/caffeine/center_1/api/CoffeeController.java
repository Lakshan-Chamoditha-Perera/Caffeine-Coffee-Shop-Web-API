package lk.caffeine.center_1.api;

import jakarta.validation.Valid;
import lk.caffeine.center_1.dto.CoffeeDto;
import lk.caffeine.center_1.service.BaristaService;
import lk.caffeine.center_1.service.CoffeeService;
import lk.caffeine.center_1.util.payload.StandardMessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: shan
 * Created: 1/16/24 12:25 AM
 */
@RestController
@RequestMapping("/api/v1/coffee")
@RequiredArgsConstructor
public class CoffeeController {
    private final CoffeeService coffeeService;
    private final BaristaService baristaService;

    @PostMapping
    @RequestMapping("/save")
    public ResponseEntity<StandardMessageResponse> save(@Valid @RequestBody CoffeeDto coffeeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardMessageResponse(500, "Fail", bindingResult.getAllErrors()));
        }
        try {
            coffeeService.save(coffeeDto);
            return ResponseEntity.ok(new StandardMessageResponse(200, "Success", null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardMessageResponse(500, "Error ", e.getMessage()));
        }
    }

    @DeleteMapping
    @RequestMapping("/delete")
    public StandardMessageResponse delete(@RequestParam String id) {
        try {
            coffeeService.delete(id);
            return new StandardMessageResponse(200, "Success", null);
        } catch (RuntimeException e) {
            return new StandardMessageResponse(500, "Error", e.getMessage());
        }
    }

    @GetMapping
    @RequestMapping("/getAll")
    public StandardMessageResponse getAll() {
        List<CoffeeDto> coffeeDtos = coffeeService.getAll();
        return new StandardMessageResponse(200, "Success", coffeeDtos);
    }

    @PatchMapping
    @RequestMapping("/update")
    public StandardMessageResponse update(@Valid @RequestBody CoffeeDto coffeeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new StandardMessageResponse(500, "Fail", bindingResult.getAllErrors());
        }
        try {
            coffeeService.update(coffeeDto);
            return new StandardMessageResponse(200, "Success", null);
        } catch (RuntimeException e) {
            return new StandardMessageResponse(500, "Error", e.getMessage());
        }
    }
}
