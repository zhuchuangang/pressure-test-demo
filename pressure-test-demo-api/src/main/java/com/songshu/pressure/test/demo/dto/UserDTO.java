package com.songshu.pressure.test.demo.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 鼠笑天
 * @date 2019/12/29
 */
@Data
public class UserDTO implements Serializable {

    private Long id;

    private String name;

    private Integer age;
}
