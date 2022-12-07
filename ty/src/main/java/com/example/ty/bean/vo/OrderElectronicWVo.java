package com.example.ty.bean.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
@Data
public class OrderElectronicWVo implements Serializable{
    private Integer oid;
    private Integer eid;
    private LocalDateTime otime;
    private String ebrand;
    private String emodel;
    private String eimage;
    private BigDecimal eprice;
    private String ecolor;
    private String edesp;
    private Integer uid;
    private Integer ostate;
}
