package com.crazysky.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用返回类
 * @author CrazySky
 * @date 2021/03/01 13:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    /**
     * 只状态码和提示信息参数的构造函数
     * @author CrazySky
     * @date 2021/03/01 18:28
     * @param code 状态码
     * @param message 提示信息
     */
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
