package com.southwind.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class SearchRecord implements Serializable {

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

    private String txtPlace;

    private Integer currentPage;

}
