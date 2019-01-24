package com.day3.belajar1.webmodel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse<T> {
    String status;
    String code;
    private T data;
    private String errorMessage;

}
