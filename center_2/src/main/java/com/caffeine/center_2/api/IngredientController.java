package com.caffeine.center_2.api;

import com.caffeine.center_2.dto.IngredientDto;
import com.caffeine.center_2.util.payload.StandardMessageResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: shan
 * Created: 1/20/24 12:11 AM
 */
@RestController
@RequestMapping("/api/ingredient")

public class IngredientController {
    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<StandardMessageResponse> getIngredient() {

        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = "application/json")
    @RequestMapping("/save")
    public ResponseEntity<StandardMessageResponse> postIngredient(@Valid @RequestBody IngredientDto ingredientDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardMessageResponse(500, "Fail", bindingResult.getAllErrors()));
        }



        try {
//         ---------------------
            return ResponseEntity.ok(new StandardMessageResponse(200, "Success", null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardMessageResponse(500, "Error ", e.getMessage()));
        }

    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity<StandardMessageResponse> deleteIngredient(String id) {
        return ResponseEntity.ok(new StandardMessageResponse(200, "Success", null));
    }

    @GetMapping
    @RequestMapping("/getAll")
    public ResponseEntity<StandardMessageResponse> getAllIngredient() {
        return ResponseEntity.ok(new StandardMessageResponse(200, "Success", null));
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
