package lk.caffeine.center_1.util.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Author: shan
 * Created: 1/15/24 8:33 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StandardMessageResponse {
    private int code;
    private String message;
    private Object data;
}
