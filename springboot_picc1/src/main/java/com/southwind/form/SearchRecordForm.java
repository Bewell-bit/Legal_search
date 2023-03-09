package com.southwind.form;

import lombok.Data;

@Data
public class SearchRecordForm {
    private String txtId;
    private String txtTitle;
    private String userId; //这个是用户token
    private String createdTime;
    private String txtType; //案件类型
    private String txtPlace;  //法院
    private Integer currentPage;
}
