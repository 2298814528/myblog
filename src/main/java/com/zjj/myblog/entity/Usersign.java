package com.zjj.myblog.entity;

import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 签到表
 * </p>
 *
 * @author author
 * @since 2020-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Usersign implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String user;

    /**
     * 签到时间
     */
    @TableField("signTime")
    private LocalDate signTime;


}
