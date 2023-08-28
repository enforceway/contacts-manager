package com.enforceway.application.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_phonebook")
public class ContactItem {

    @TableId
    private Integer id;

    private String name;

    private String phoneNumber;

    private String teleNumber;

    private String workAddress;

    private String homeAddress;

    private String image;

    @TableField("image_name")
    private String imageName;

    private String remark;

    private String initial;

}
