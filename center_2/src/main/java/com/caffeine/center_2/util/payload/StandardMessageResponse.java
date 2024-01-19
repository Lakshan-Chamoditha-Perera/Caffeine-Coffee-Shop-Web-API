package com.caffeine.center_2.util.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Author: shan
 * Created: 1/20/24 12:23 AM
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
