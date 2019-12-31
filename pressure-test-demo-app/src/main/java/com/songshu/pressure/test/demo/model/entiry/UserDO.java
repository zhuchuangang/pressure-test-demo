package com.songshu.pressure.test.demo.model.entiry;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * @author 鼠笑天
 * @date 2019/12/24
 */
@Data
@TableName("t_user")
public class UserDO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -2571120227159681181L;
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 压测测表示 true表示压测，false表示非压测
     */
    @TableField(exist = false)
    private Boolean pressureTestMark;
}
