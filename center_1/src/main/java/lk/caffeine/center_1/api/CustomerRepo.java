package lk.caffeine.center_1.api;

import lk.caffeine.center_1.dto.CustomerDto;
import lk.caffeine.center_1.util.payload.StandardMessageResponse;
import org.springframework.web.bind.annotation.*;

/**
 * Author: shan
 * Created: 1/15/24 8:39 PM
 */
@RestController("api/v1/customer")
public class CustomerRepo {
    @GetMapping
    @RequestMapping("/getAll")
    public StandardMessageResponse getAll() {
        return new StandardMessageResponse(200, "Success", null);
    }

    @PostMapping
    @RequestMapping("/save")
    public StandardMessageResponse save(@RequestBody CustomerDto dto) {
        return new StandardMessageResponse(200, "Success", null);
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


}
