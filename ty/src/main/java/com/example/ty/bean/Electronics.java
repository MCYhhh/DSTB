package com.example.ty.bean;

import java.math.BigDecimal;
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
public class Electronics implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Eid", type = IdType.AUTO)
    private Integer eid;

    @TableField("Ebrand")
    private String ebrand;

    @TableField("Emodel")
    private String emodel;

    @TableField("Eimage")
    private String eimage;

    @TableField("Eprice")
    private BigDecimal eprice;

    @TableField("Ecolor")
    private String ecolor;

    @TableField("Edesp")
    private String edesp;


}
