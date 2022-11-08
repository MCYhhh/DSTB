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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Uid", type = IdType.AUTO)
    private Integer uid;

    @TableField("Uaccount")
    private String uaccount;

    @TableField("Uname")
    private String uname;

    @TableField("Upwd")
    private String upwd;

    @TableField("Usex")
    private String usex;

    @TableField("Uimage")
    private String uimage;

    @TableField("Utel")
    private String utel;

    @TableField("Usite")
    private String usite;


}
