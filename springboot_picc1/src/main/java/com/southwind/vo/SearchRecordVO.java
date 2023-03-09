package com.southwind.vo;

import lombok.Data;

@Data
public class SearchRecordVO {
    private Integer id;
    private String txtId;
    private String txtTitle;
    private String createdTime;
    private String txtType;
    private String txtPlace;
    private Integer currentPage;
}
