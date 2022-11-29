package com.example.ty.bean.Addition;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class UserAddition {
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

    private String token;//  用户的token

        public void setToken(String token1) {
            this.token=token1;

    }
}
