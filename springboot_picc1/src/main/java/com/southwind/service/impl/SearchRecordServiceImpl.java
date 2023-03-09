package com.southwind.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.southwind.entity.SaveRecord;
import com.southwind.entity.SearchRecord;
import com.southwind.form.DelRecordForm;
import com.southwind.form.SearchForm;
import com.southwind.mapper.SaveRecordMapper;
import com.southwind.mapper.SearchRecordMapper;
import com.southwind.service.SaveRecordService;
import com.southwind.service.SearchRecordService;
import com.southwind.vo.PageVO;
import com.southwind.vo.SaveRecordVO;
import com.southwind.vo.SearchRecordVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchRecordServiceImpl extends ServiceImpl<SearchRecordMapper,SearchRecord> implements SearchRecordService {

    @Autowired
    private SearchRecordMapper searchRecordMapper;

    @Override
    public Boolean deleteRecord(DelRecordForm delRecordForm) {
        QueryWrapper<SearchRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", delRecordForm.getUserId());
        queryWrapper.eq("txt_id", delRecordForm.getTxtId());
        int delete = this.searchRecordMapper.delete(queryWrapper);
        if(delete != 1) return false;
        return true;
    }

    @Override
    public PageVO list(Integer page, Integer size, String user_id) {
        String token = user_id;
        Claims claims= Jwts.parser()
                .setSigningKey("my-123")
                .parseClaimsJws(token)
                .getBody();
        int user_number = Integer.parseInt(claims.getId());  //得到对应用户的id
        QueryWrapper<SearchRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user_number);
        Page<SearchRecord> searchRecordPage = new Page<>(page, size);
        Page<SearchRecord> resultPage = this.searchRecordMapper.selectPage(searchRecordPage, queryWrapper);
        //获取到SaveRecord对应页的所有列的信息
        List<SearchRecord> searchRecordList = resultPage.getRecords();
        //VO转换

        List<SearchRecordVO> searchRecordVOList = new ArrayList<>();
        for (SearchRecord searchRecord : searchRecordList) {
            SearchRecordVO searchRecordVO = new SearchRecordVO();

            BeanUtils.copyProperties(searchRecord, searchRecordVO);
            searchRecordVOList.add(searchRecordVO);
        }
        PageVO pageVO = new PageVO();
        pageVO.setData(searchRecordVOList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }

    @Override
    public PageVO search(SearchForm searchForm) {
        Page<SearchRecord> searchRecordPage = new Page<>(searchForm.getPage(), searchForm.getSize());
        Page<SearchRecord> resultPage = null;
        QueryWrapper<SearchRecord> queryWrapper1 = new QueryWrapper<>();
        String token = searchForm.getUserId();
        Claims claims= Jwts.parser()
                .setSigningKey("my-123")
                .parseClaimsJws(token)
                .getBody();
        int user_number = Integer.parseInt(claims.getId());  //得到对应用户的id
        queryWrapper1.eq("user_id", user_number);
        if(searchForm.getKey().equals("全部案件")) {
            queryWrapper1.like("txt_title", searchForm.getValue());
            resultPage = this.searchRecordMapper.selectPage(searchRecordPage, queryWrapper1);
        }else {
            queryWrapper1.eq("txt_type", searchForm.getKey());
            queryWrapper1.like("txt_title", searchForm.getValue());
            resultPage = this.searchRecordMapper.selectPage(searchRecordPage, queryWrapper1);
        }
        List<SearchRecord> searchRecordList = resultPage.getRecords();
        //VO转换
        List<SearchRecordVO> searchRecordVOList = new ArrayList<>();
        for (SearchRecord searchRecord : searchRecordList) {
            SearchRecordVO searchRecordVO = new SearchRecordVO();
            BeanUtils.copyProperties(searchRecord, searchRecordVO);
            searchRecordVOList.add(searchRecordVO);
        }
        PageVO pageVO = new PageVO();
        pageVO.setData(searchRecordVOList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }
}
