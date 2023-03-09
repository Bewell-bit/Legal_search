package com.southwind.form;

import lombok.Data;

@Data
public class SearchForm {
    private String userId;   //用户token
    private String key;  //案件类型（如：刑事案件）
    private String value;   //文书关键字（如：中国）
    private Integer page;
    private Integer size;
}
