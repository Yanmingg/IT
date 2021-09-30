package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author MarkerHub
 * @since 2021-09-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("CustomerID")
    private Integer CustomerID;

    @TableField("Phone")
    private Integer Phone;

    @TableField("Email")
    private String Email;

    @TableField("Address")
    private String Address;

    @TableField("Name")
    private String Name;

    @TableField("Password")
    private String Password;


}
