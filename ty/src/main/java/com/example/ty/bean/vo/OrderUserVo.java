package com.example.ty.bean.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data
public class OrderUserVo  implements Serializable{

    private Integer uid;

    private String uaccount;

    private String uname;

    private String usex;

    private String uimage;

    private String utel;

    private String usite;

}
