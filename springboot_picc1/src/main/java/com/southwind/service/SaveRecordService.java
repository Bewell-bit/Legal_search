package com.southwind.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.southwind.entity.SaveRecord;
import com.southwind.form.DelRecordForm;
import com.southwind.form.SearchForm;
import com.southwind.vo.PageVO;
import com.southwind.vo.ResultVO;

public interface SaveRecordService extends IService<SaveRecord> {
    public Boolean deleteRecord(DelRecordForm delRecordForm);
    public PageVO list(Integer page, Integer size, String user_id);
    public PageVO search(SearchForm searchForm);
}
