package com.caffeine.center_2.api;

import com.caffeine.center_2.util.payload.StandardMessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @RequestMapping("/save")
    public ResponseEntity<StandardMessageResponse>  postIngredient() {
        return ResponseEntity.ok(new StandardMessageResponse(200, "Success", null));
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity<StandardMessageResponse>  deleteIngredient(String id) {
        return ResponseEntity.ok(new StandardMessageResponse(200, "Success", null));
    }

    @GetMapping
    @RequestMapping("/getAll")
    public ResponseEntity<StandardMessageResponse>  getAllIngredient() {
        return ResponseEntity.ok(new StandardMessageResponse(200, "Success", null));
    }

}
