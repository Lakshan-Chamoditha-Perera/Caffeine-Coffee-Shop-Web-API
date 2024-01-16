package lk.caffeine.center_1.api;

import lk.caffeine.center_1.dto.OrdersDto;
import lk.caffeine.center_1.service.OrdersService;
import lk.caffeine.center_1.util.payload.StandardMessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Author: shan
 * Created: 1/16/24 11:56 AM
 */
@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<StandardMessageResponse> saveOrder(@RequestBody OrdersDto ordersDto){

        ordersService.save(ordersDto);
        return ResponseEntity.ok(new StandardMessageResponse(200, "Success", null));
    }

    @GetMapping
    @RequestMapping("/getOngoingId")
    public ResponseEntity<StandardMessageResponse> getOngoingId(){
        String id = ordersService.getOngoingOrderId();
        return ResponseEntity.ok(new StandardMessageResponse(200, "Success", id));
    }
}
