package com.example.ty.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author MCY
 * @since 2022-11-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Wid", type = IdType.AUTO)
    private Integer wid;

    @TableField("Waccount")
    private String waccount;

    @TableField("Wname")
    private String wname;

    @TableField("Wpwd")
    private String wpwd;

    @TableField("Wtype")
    private Integer wtype;


}
