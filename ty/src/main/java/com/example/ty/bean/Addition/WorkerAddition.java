package com.example.ty.bean.Addition;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class WorkerAddition {

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

    private String token;//  公司人员的token

    public void setToken(String token1) {
        this.token = token1;
    }
}
