package lk.caffeine.center_1.api;

import jakarta.validation.Valid;
import lk.caffeine.center_1.dto.CustomerDto;
import lk.caffeine.center_1.service.CustomerService;
import lk.caffeine.center_1.util.payload.StandardMessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: shan
 * Created: 1/15/24 8:39 PM
 */
@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    @RequestMapping("/getAll")
    public StandardMessageResponse getAll() {
        return new StandardMessageResponse(200, "Success", null);
    }

    @PostMapping
    @RequestMapping("/save")
    public ResponseEntity<StandardMessageResponse> save(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult) {
        System.out.println(customerDto);
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardMessageResponse(500, "Fail", bindingResult.getAllErrors()));
        }
        try {
            customerService.save(customerDto);
            return ResponseEntity.ok(new StandardMessageResponse(200, "Success", null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardMessageResponse(500, "Error ", e.getMessage()));
        }
    }

    @PatchMapping(consumes = "application/json")
    @RequestMapping("/update")
    public StandardMessageResponse update() {
        return new StandardMessageResponse(200, "Success", null);
    }

    @DeleteMapping
    @RequestMapping("/delete")
    public StandardMessageResponse delete(@RequestParam String id) {
        return new StandardMessageResponse(200, "Success", null);
    }

    @GetMapping
    @RequestMapping("/existsById")
    public StandardMessageResponse existsById(@RequestParam String id) {
        return new StandardMessageResponse(200, "Success", null);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public StandardMessageResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((org.springframework.validation.FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new StandardMessageResponse(500, "Fail", errors);
    }

}
