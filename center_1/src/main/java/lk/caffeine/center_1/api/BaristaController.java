package lk.caffeine.center_1.api;

import jakarta.validation.Valid;
import lk.caffeine.center_1.dto.BaristaDto;
import lk.caffeine.center_1.service.BaristaService;
import lk.caffeine.center_1.util.payload.StandardMessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            return ResponseEntity.status(
                    HttpStatus.BAD_REQUEST).body(
                            new StandardMessageResponse(500, "Fail", bindingResult.getAllErrors()));
        }
        try {
            baristaService.save(baristaDto);
            return ResponseEntity.ok(new StandardMessageResponse(200, "Success", null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(
                    HttpStatus.BAD_REQUEST).body(
                            new StandardMessageResponse(500, "Error ", e.getMessage()));
        }
    }

    @PatchMapping(consumes = "application/json")
    @RequestMapping("/update")
    public ResponseEntity<StandardMessageResponse> update(@Valid @RequestBody BaristaDto baristaDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(
                    HttpStatus.BAD_REQUEST).body(
                            new StandardMessageResponse(500, "Fail", bindingResult.getAllErrors()));
        }
        try {
            if (baristaService.existsById(baristaDto.getId())) {
                baristaService.update(baristaDto);
                return ResponseEntity.ok(new StandardMessageResponse(200, "Success", null));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardMessageResponse(500, "Error ", "No such customer for update..!"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardMessageResponse(500, "Error ", e.getMessage()));
        }
    }

    @DeleteMapping
    @RequestMapping("/delete")
    public ResponseEntity<StandardMessageResponse> delete(@RequestParam String id) {
        try {
            baristaService.delete(id);
            return ResponseEntity.ok(new StandardMessageResponse(200, "Success", null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardMessageResponse(500, "Error ", e.getMessage()));
        }
    }

    @GetMapping
    @RequestMapping("/existsById")
    public ResponseEntity<StandardMessageResponse> existsById(@RequestParam String id) {
        try {
            if (baristaService.existsById(id)) {
                return ResponseEntity.ok(new StandardMessageResponse(200, "Success", null));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardMessageResponse(500, "Error ", "No such barista for delete..!"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardMessageResponse(500, "Error ", e.getMessage()));
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardMessageResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((org.springframework.validation.FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardMessageResponse(500, "Fail", errors));
    }

}
