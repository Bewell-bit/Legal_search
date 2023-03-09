package com.southwind.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SaveRecord implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文书的id
     */
    private String txtId;

    /**
     * 文书的标题
     */
    private String txtTitle;

    /**
     * 用户的id
     */
    private Integer userId;

    /**
     * 收藏的日期
     */
    private String createdTime;

    private String txtType;

    private Integer currentPage;

}
