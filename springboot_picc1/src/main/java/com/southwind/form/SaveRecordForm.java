package com.southwind.form;

import lombok.Data;

@Data
public class SaveRecordForm {
    private String txtId;
    private String txtTitle;
    private String userId; //这个是用户token
    private String createdTime;
    private String txtType; //案件类型
    private Integer currentPage;
}
