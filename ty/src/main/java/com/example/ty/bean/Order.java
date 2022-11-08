package com.example.ty.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Oid", type = IdType.AUTO)
    private Integer oid;

    @TableField("Uid")
    private Integer uid;

    @TableField("Eid")
    private Integer eid;

    @TableField("Wid")
    private Integer wid;

    @TableField("Otime")
    private LocalDateTime otime;

    @TableField("Ostate")
    private Integer ostate;


}
