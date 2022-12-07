package com.example.ty.bean.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class OrderElectronicVo implements Serializable{
   private Integer oid;
   private Integer eid;
   private LocalDateTime otime;
   private String ebrand;
   private String emodel;
   private String eimage;
   private BigDecimal eprice;
   private String ecolor;
   private String edesp;
   private Integer wid;
   private Integer ostate;

}
